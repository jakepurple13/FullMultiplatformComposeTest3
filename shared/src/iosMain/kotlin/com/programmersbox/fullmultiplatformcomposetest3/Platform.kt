package com.programmersbox.fullmultiplatformcomposetest3

import androidx.compose.ui.window.Application
import platform.UIKit.UIDevice
import platform.UIKit.UIViewController

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

fun MainViewControllerPlatform(): UIViewController = Application("Falling Balls") { ImageViewerIos() }