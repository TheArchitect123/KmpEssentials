package com.architect.kmpessentials.backgrounding.helpers

import com.architect.kmpessentials.aliases.DefaultActionAsync
import kotlinx.browser.window
import kotlin.random.Random

object WebWorkers {
    private val actionMap = mutableListOf<String>()

    fun registerServiceWorker(action: DefaultActionAsync) {
        val actionId = Random(100000).toString()
        actionMap.add(actionId) // Track running action

        val serviceWorkerScript = """
        self.addEventListener("install", (event) => {
            console.log("Service Worker installed.");
            self.skipWaiting();
        });

        self.addEventListener("activate", (event) => {
            console.log("Service Worker activated.");
        });

        self.addEventListener("message", async (event) => {
            console.log("Service Worker received message:", event.data);

            if (event.data.type === "execute_action") {
                if (self.runningTasks?.has(event.data.actionId)) {
                    console.log("Skipping execution, task already running:", event.data.actionId);
                    return;
                }

                console.log("Executing action inside Service Worker for actionId:", event.data.actionId);
                
                // Convert function code back into a function
                const receivedFunction = new Function("return " + event.data.actionCode)();
                
                // Store task for potential cancellation
                self.runningTasks = self.runningTasks || new Map();
                const taskPromise = receivedFunction();
                self.runningTasks.set(event.data.actionId, taskPromise);

                try {
                    // Execute the function inside the worker
                    const result = await taskPromise;

                    // Send result back to Kotlin/JS
                    event.source.postMessage({ 
                        type: "action_result", 
                        actionId: event.data.actionId, 
                        result: result 
                    });
                } catch (error) {
                    console.error("Error in Service Worker task:", error);
                } finally {
                    self.runningTasks.delete(event.data.actionId); // Cleanup
                }
            }
        });

        self.addEventListener("message", (event) => {
            if (event.data.type === "cancel_task") {
                console.log("Service Worker: Cancelling task", event.data.actionId);
                if (self.runningTasks?.has(event.data.actionId)) {
                    self.runningTasks.delete(event.data.actionId); // Remove from active list
                }
            }
        });

    """.trimIndent()

        val blob =
            js("new Blob([arguments[0]], { type: 'application/javascript' })")(serviceWorkerScript)
        val workerUrl = js("URL.createObjectURL(arguments[0])")(blob).toString()

        if (js("typeof navigator.serviceWorker !== 'undefined'") as Boolean) {
            window.navigator.serviceWorker.register(workerUrl).then { registration ->
                console.log("Dynamic Service Worker registered successfully.")

                window.navigator.serviceWorker.ready.then { swRegistration ->
                    console.log("Service Worker is ready.")

                    // Send the action JavaScript code to the worker
                    swRegistration.active?.postMessage(
                        js("({ type: 'execute_action', actionId: arguments[0], actionCode: arguments[1] })")(
                            actionId, action
                        )
                    )
                }
            }.catch { error ->
                console.error("Failed to register Service Worker:", error)
            }
        } else {
            console.error("Service Worker API is not supported in this browser.")
        }
    }

    fun registerWebWorker(action: DefaultActionAsync) {
        val actionId = Random(100000).toString()
        actionMap.add(actionId) // Track running action

        val workerScript = """
        self.onmessage = async (event) => {
            console.log("Web Worker received message:", event.data);

            if (event.data.type === "execute_action") {
                if (self.runningTasks?.has(event.data.actionId)) {
                    console.log("Skipping execution, task already running:", event.data.actionId);
                    return;
                }

                console.log("Executing Web Worker action for actionId:", event.data.actionId);
                
                // Convert the received function code back into a function
                const receivedFunction = new Function("return " + event.data.actionCode)();
                
                // Store task for potential cancellation
                self.runningTasks = self.runningTasks || new Map();
                const taskPromise = receivedFunction();
                self.runningTasks.set(event.data.actionId, taskPromise);

                try {
                    // Execute the function inside the Web Worker
                    const result = await taskPromise;

                    // Send result back to Kotlin/JS
                    self.postMessage({ 
                        type: "action_result", 
                        actionId: event.data.actionId, 
                        result: result 
                    });
                } catch (error) {
                    console.error("Error in Web Worker task:", error);
                } finally {
                    self.runningTasks.delete(event.data.actionId); // Cleanup
                }
            }
        };

        self.onmessage = (event) => {
            if (event.data.type === "cancel_task") {
                console.log("Web Worker: Cancelling task", event.data.actionId);
                if (self.runningTasks?.has(event.data.actionId)) {
                    self.runningTasks.delete(event.data.actionId); // Remove from active list
                }
            }
        };
    """.trimIndent()

        val blob = js("new Blob([arguments[0]], { type: 'application/javascript' })")(workerScript)
        val workerUrl = js("URL.createObjectURL(arguments[0])")(blob).toString()

        val worker = js("new Worker(arguments[0])")(workerUrl)

        worker.asDynamic().onmessage = { event: dynamic ->
            val eventData = event.asDynamic().data
            if (eventData.type == "action_result") {
                console.log("Received result from Web Worker:", eventData.result)
            }
        }

        worker.asDynamic().postMessage(
            js("({ type: 'execute_action', actionId: arguments[0], actionCode: arguments[1] })")(
                actionId, action
            )
        )
    }

    fun cancellAllTasks() {
        actionMap.forEach {
            window.navigator.serviceWorker.controller?.postMessage(
                js("({ type: 'cancel_task', actionId: arguments[0] })")(it)
            )
        }
    }
}