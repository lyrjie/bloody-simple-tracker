package com.lyrjie.bloodysimpletracker.components.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lyrjie.bloodysimpletracker.components.ui.common.placeholder.ScreenPlaceholder
import com.lyrjie.bloodysimpletracker.components.ui.theme.TrackerTheme
import com.lyrjie.bloodysimpletracker.components.ui.tooling.ThemePreviews

@Composable
fun LoginScreen(
    showHome: () -> Unit,
) {
    ScreenPlaceholder(
        title = "Login Screen",
    ) {
        Button(
            onClick = showHome,
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
            )
        }
    }
}

@ThemePreviews
@Composable
private fun LoginScreenPreview() {
    TrackerTheme {
        LoginScreen(
            showHome = {}
        )
    }
}
