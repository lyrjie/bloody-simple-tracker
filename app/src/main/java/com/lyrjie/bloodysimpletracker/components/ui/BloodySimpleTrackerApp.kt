package com.lyrjie.bloodysimpletracker.components.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lyrjie.bloodysimpletracker.components.ui.theme.BloodySimpleTrackerTheme

@Composable
fun BloodSimpleTrackerApp() {
    BloodySimpleTrackerTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        )
    }
}