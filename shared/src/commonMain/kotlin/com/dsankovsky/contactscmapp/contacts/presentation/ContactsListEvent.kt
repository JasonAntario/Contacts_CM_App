package com.dsankovsky.contactscmapp.contacts.presentation

import com.dsankovsky.contactscmapp.contacts.domain.Contact

sealed interface ContactsListEvent {

    object OnAddNewContactClick : ContactsListEvent
    object DismissContact : ContactsListEvent
    data class OnFirstNameChanged(val value: String) : ContactsListEvent
    data class OnLastNameChanged(val value: String) : ContactsListEvent
    data class OnEmailChanged(val value: String) : ContactsListEvent
    data class OnPhoneNumberChanged(val value: String) : ContactsListEvent
    data class OnPhotoPicked(val bytes: ByteArray) : ContactsListEvent
    object OnAddPhotoClicked : ContactsListEvent
    object SaveContact : ContactsListEvent
    data class SelectContact(val contact: Contact) : ContactsListEvent
    data class EditContact(val contact: Contact) : ContactsListEvent
    object DeleteContact : ContactsListEvent

}