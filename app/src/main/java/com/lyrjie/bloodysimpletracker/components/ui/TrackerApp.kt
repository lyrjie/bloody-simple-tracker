package com.lyrjie.bloodysimpletracker.components.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lyrjie.bloodysimpletracker.components.ui.common.systemui.TransparentSystemBars
import com.lyrjie.bloodysimpletracker.components.ui.theme.TrackerTheme

@Composable
fun TrackerApp() {
    TrackerTheme {
        TransparentSystemBars(useDarkIcons = !isSystemInDarkTheme())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        )
    }
}
