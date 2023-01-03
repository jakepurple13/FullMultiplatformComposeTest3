package com.programmersbox.fullmultiplatformcomposetest3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import example.imageviewer.ImageViewerCommon

@Composable
internal fun ImageViewerIos() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ImageViewerCommon()
    }
}
