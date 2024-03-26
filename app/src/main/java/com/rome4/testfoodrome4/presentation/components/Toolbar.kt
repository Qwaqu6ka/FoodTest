package com.rome4.testfoodrome4.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.rome4.testfoodrome4.R
import com.rome4.testfoodrome4.presentation.models.UICity
import com.rome4.testfoodrome4.presentation.theme.AppTheme
import kotlinx.collections.immutable.ImmutableList

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    cities: ImmutableList<UICity>,
    activeCity: UICity,
    onActiveCityChange: (UICity) -> Unit,
    onScanQrCode: () -> Unit,
    dropdownEnabled: Boolean = true
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .padding(AppTheme.sizes.toolbar.contentPadding)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CityButton(
                cities = cities,
                activeCity = activeCity,
                onActiveCityChange = onActiveCityChange,
                enabled = dropdownEnabled
            )
            IconButton(onClick = onScanQrCode) {
                Icon(
                    painter = painterResource(R.drawable.ic_qr_code),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityButton(
    cities: ImmutableList<UICity>,
    activeCity: UICity,
    onActiveCityChange: (UICity) -> Unit,
    enabled: Boolean = true
) {
    var expanded by remember { mutableStateOf(false) }
    val iconRotation = remember { Animatable(0f) }

    LaunchedEffect(key1 = expanded) {
        if (expanded) {
            iconRotation.animateTo(0f)
        } else {
            iconRotation.animateTo(180f)
        }
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { if (enabled) expanded = !expanded }) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(AppTheme.sizes.toolbar.cityArrowArrangement),
            modifier = Modifier.menuAnchor()
        ) {
            Text(
                text = activeCity.title,
                style = AppTheme.typography.menu.toolbarCity,
                color = Color.Black
            )
            Icon(
                painter = painterResource(R.drawable.ic_arrow_down),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.rotate(iconRotation.value)
            )
        }

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            for (city in cities) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = city.title,
                            style = AppTheme.typography.menu.toolbarCity,
                            color = Color.Black
                        )
                    },
                    onClick = { onActiveCityChange(city); expanded = false }
                )
            }
        }
    }
}