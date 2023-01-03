package example.imageviewer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.programmersbox.fullmultiplatformcomposetest3.MainApp

@Composable
internal fun ImageViewerCommon() {
    Surface(modifier = Modifier.fillMaxSize()) {
        MainApp()
    }
}
