package com.dsankovsky.contactscmapp.di

import com.dsankovsky.contactscmapp.contacts.data.SqlDelightContactDataSource
import com.dsankovsky.contactscmapp.contacts.domain.ContactsDataSource
import com.dsankovsky.contactscmapp.core.data.DatabaseDriverFactory
import com.dsankovsky.contactscmapp.core.data.ImageStorage
import com.dsankovsky.contactscmapp.database.ContactDatabase

actual class AppModule {

    actual val contactsDataSource: ContactsDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory().create()
            ),
            imageStorage = ImageStorage()
        )
    }
}