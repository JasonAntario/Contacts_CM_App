package com.dsankovsky.contactscmapp.contacts.data

import com.dsankovsky.contactscmapp.contacts.domain.Contact
import com.dsankovsky.contactscmapp.core.data.ImageStorage
import database.ContactEntity

suspend fun ContactEntity.toContact(imageStorage: ImageStorage) =
    Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phoneNumber,
        photoBytes = imagePath?.let { imageStorage.getImage(it) }
    )