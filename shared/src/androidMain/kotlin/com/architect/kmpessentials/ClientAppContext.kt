package com.architect.kmpessentials

import android.content.Context
import androidx.startup.Initializer

// application context registered by the client app via its manifest
internal class ClientAppContext : Initializer<Context> {
    companion object {
        internal lateinit var clientAppContext: Context
    }

    override fun create(context: Context): Context {
        clientAppContext = context
        return context
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}