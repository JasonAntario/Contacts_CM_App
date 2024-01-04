package com.dsankovsky.contactscmapp.di

import com.dsankovsky.contactscmapp.contacts.domain.ContactsDataSource

expect class AppModule {

    val contactsDataSource: ContactsDataSource
}