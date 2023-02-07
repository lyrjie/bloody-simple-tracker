package com.lyrjie.bloodysimpletracker.components.ui.tooling

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "light theme",
    group = "themes",
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "dark theme",
    group = "themes",
    uiMode = UI_MODE_NIGHT_YES
)
annotation class ThemePreviews

@Preview(
    name = "small font scale",
    group = "font scales",
    fontScale = 0.5f
)
@Preview(
    name = "large font scale",
    group = "font scales",
    fontScale = 1.5f
)
annotation class FontScalePreviews

// Sample screen sizes taken from https://gist.github.com/uqmessias/4bb9d8ed90d3ebca1c387c114a71c66a
@Preview(
    name = "mdpi / 160",
    group = "densities",
    device = "spec:width=320px,height=480px,dpi=160",
)
@Preview(
    name = "hdpi / 240",
    group = "densities",
    device = "spec:width=480px,height=800px,dpi=240",
)
@Preview(
    name = "xhdpi / 320",
    group = "densities",
    device = "spec:width=720px,height=1280px,dpi=320",
)
@Preview(
    name = "xxhdpi / 480",
    group = "densities",
    device = "spec:width=1080px,height=2340px,dpi=480",
)
@Preview(
    name = "xxxhdpi / 640",
    group = "densities",
    device = "spec:width=1440px,height=2560px,dpi=640",
)
annotation class DensityPreviews
