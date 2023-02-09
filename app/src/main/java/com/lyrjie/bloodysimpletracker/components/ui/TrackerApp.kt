package com.lyrjie.bloodysimpletracker.components.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.lyrjie.bloodysimpletracker.components.ui.common.systemui.TransparentSystemBars
import com.lyrjie.bloodysimpletracker.components.ui.navigation.TrackerNavigation
import com.lyrjie.bloodysimpletracker.components.ui.theme.TrackerTheme

@Composable
fun TrackerApp() {
    TrackerTheme {
        TransparentSystemBars(useDarkIcons = !isSystemInDarkTheme())
        TrackerNavigation()
    }
}
