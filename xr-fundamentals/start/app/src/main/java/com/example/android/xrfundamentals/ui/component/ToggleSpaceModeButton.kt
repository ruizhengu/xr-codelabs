package com.example.android.xrfundamentals.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.xr.compose.platform.LocalSpatialCapabilities
import androidx.xr.compose.platform.LocalSpatialConfiguration
import com.example.android.xrfundamentals.R
import com.example.android.xrfundamentals.ui.theme.XRFundamentalsTheme

@Composable
fun ToggleSpaceModeButton(modifier: Modifier = Modifier) {
    val spatialConfiguration = LocalSpatialConfiguration.current

    if (LocalSpatialCapabilities.current.isSpatialUiEnabled) {
        ToggleSpaceModeButton(
            modifier = modifier,
            contentDescription = "Request Home Space mode",
            iconResource = R.drawable.ic_home_space_mode,
            onClick = { spatialConfiguration.requestHomeSpaceMode() }
        )
    } else {
        ToggleSpaceModeButton(
            modifier = modifier,
            contentDescription = "Request Full Space mode",
            iconResource = R.drawable.ic_full_space_mode,
            onClick = { spatialConfiguration.requestFullSpaceMode() }
        )
    }
}

@Composable
fun ToggleSpaceModeButton(
    contentDescription: String,
    @DrawableRes iconResource: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            painterResource(iconResource),
            contentDescription
        )
    }
}