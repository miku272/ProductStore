package me.nareshsharma.mycamera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import me.nareshsharma.mycamera.core.theme.MyApplicationTheme
import me.nareshsharma.mycamera.features.camera.presentation.MyCameraScreen

@AndroidEntryPoint
class MyCameraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MyCameraScreen()
            }
        }
    }
}