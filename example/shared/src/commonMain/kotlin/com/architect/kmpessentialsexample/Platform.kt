package com.architect.kmpessentialsexample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform