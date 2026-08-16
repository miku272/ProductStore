package me.nareshsharma.mycamera.features.camera.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nareshsharma.core.designsystem.Dimens

@Composable
fun MyCameraScreen() {
    Scaffold {innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = Dimens.Spacing.Medium)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Camera Screen",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCameraScreenPreview() {
    MyCameraScreen()
}