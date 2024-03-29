@file:OptIn(ExperimentalMaterial3Api::class)

package com.dsankovsky.contactscmapp.contacts.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dsankovsky.contactscmapp.contacts.domain.Contact
import com.dsankovsky.contactscmapp.contacts.presentation.ContactsListEvent
import com.dsankovsky.contactscmapp.contacts.presentation.ContactsListState
import com.dsankovsky.contactscmapp.core.presentation.BottomSheetFromWish

@Composable
fun AddContactSheet(
    state: ContactsListState,
    newContact: Contact?,
    isOpen: Boolean,
    onEvent: (ContactsListEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomSheetFromWish(
        visible = isOpen,
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                if (newContact?.photoBytes == null) {
                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(40))
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                            .clickable {
                                onEvent(ContactsListEvent.OnAddPhotoClicked)
                            }
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                shape = RoundedCornerShape(40)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                } else {
                    ContactPhoto(
                        contact = newContact,
                        modifier = Modifier
                            .size(150.dp)
                            .clickable {
                                onEvent(ContactsListEvent.OnAddPhotoClicked)
                            }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                ContactTextField(
                    value = newContact?.firstName ?: "",
                    placeHolder = "First name",
                    error = state.firstNameError,
                    onValueChanged = {
                        onEvent(ContactsListEvent.OnFirstNameChanged(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                ContactTextField(
                    value = newContact?.lastName ?: "",
                    placeHolder = "Last name",
                    error = state.lastNameError,
                    onValueChanged = {
                        onEvent(ContactsListEvent.OnLastNameChanged(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                ContactTextField(
                    value = newContact?.email ?: "",
                    placeHolder = "Email",
                    error = state.emailError,
                    onValueChanged = {
                        onEvent(ContactsListEvent.OnEmailChanged(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                ContactTextField(
                    value = newContact?.phoneNumber ?: "",
                    placeHolder = "Phone number",
                    error = state.phoneNumberError,
                    onValueChanged = {
                        onEvent(ContactsListEvent.OnPhoneNumberChanged(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    onEvent(ContactsListEvent.SaveContact)
                }) {
                    Text(text = "Save")
                }
            }
            IconButton(
                onClick = {
                    onEvent(ContactsListEvent.DismissContact)
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
private fun ContactTextField(
    value: String,
    placeHolder: String,
    error: String?,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier) {
        OutlinedTextField(
            value = value,
            placeholder = {
                Text(text = placeHolder)
            },
            onValueChange = onValueChanged,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth()
        )
        error?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}