package com.architect.testclient

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform