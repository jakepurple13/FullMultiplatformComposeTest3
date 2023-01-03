package com.programmersbox.fullmultiplatformcomposetest3

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform