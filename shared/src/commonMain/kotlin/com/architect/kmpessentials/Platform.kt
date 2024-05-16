package com.architect.kmpessentials

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform