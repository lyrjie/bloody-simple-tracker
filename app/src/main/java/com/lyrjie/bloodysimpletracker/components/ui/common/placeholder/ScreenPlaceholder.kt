package com.lyrjie.bloodysimpletracker.components.ui.common.placeholder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lyrjie.bloodysimpletracker.components.ui.theme.TrackerTheme
import com.lyrjie.bloodysimpletracker.components.ui.tooling.ThemePreviews

@Composable
fun ScreenPlaceholder(
    title: String,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = MaterialTheme.shapes.large,
            tonalElevation = 8.dp,
            shadowElevation = 8.dp
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}

@ThemePreviews
@Composable
private fun ScreenPlaceholderPreview() {
    TrackerTheme {
        ScreenPlaceholder(
            title = "Some Screen Title",
        )
    }
}
