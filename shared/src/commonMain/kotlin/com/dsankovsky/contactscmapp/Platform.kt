package com.dsankovsky.contactscmapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform