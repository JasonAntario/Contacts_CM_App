package com.dsankovsky.contactscmapp.core.presentation


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.dsankovsky.contactscmapp.ui.theme.DarkColors
import com.dsankovsky.contactscmapp.ui.theme.LightColors

@Composable
actual fun ContactsTheme(
    darkTheme: Boolean,
    dynamicColors: Boolean,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = MaterialTheme.typography,
        content = content
    )
}