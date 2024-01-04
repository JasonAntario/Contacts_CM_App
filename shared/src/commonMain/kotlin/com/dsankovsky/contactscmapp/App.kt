package com.dsankovsky.contactscmapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.dsankovsky.contactscmapp.contacts.presentation.ContactsListScreen
import com.dsankovsky.contactscmapp.contacts.presentation.ContactsListViewModel
import com.dsankovsky.contactscmapp.core.presentation.ContactsTheme
import com.dsankovsky.contactscmapp.core.presentation.ImagePicker
import com.dsankovsky.contactscmapp.di.AppModule
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColors: Boolean,
    appModule: AppModule,
    imagePicker: ImagePicker
) {
    ContactsTheme(
        darkTheme = darkTheme,
        dynamicColors = dynamicColors
    ) {
        val viewModel = getViewModel(
            key = "contacts-list-screen",
            factory = viewModelFactory {
                ContactsListViewModel(appModule.contactsDataSource)
            }
        )

        val state by viewModel.state.collectAsState()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ContactsListScreen(
                state = state,
                newContact = viewModel.newContact,
                onEvent = viewModel::onEvent,
                imagePicker = imagePicker
            )
        }
    }
}