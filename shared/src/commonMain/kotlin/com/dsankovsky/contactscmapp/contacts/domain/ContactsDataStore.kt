package com.dsankovsky.contactscmapp.contacts.domain

import kotlinx.coroutines.flow.Flow

interface ContactsDataSource {
    fun getContacts(): Flow<List<Contact>>
    fun getRecentContacts(amount: Int): Flow<List<Contact>>
    suspend fun insertContact(contact: Contact)
    suspend fun deleteContact(id: Long)
}