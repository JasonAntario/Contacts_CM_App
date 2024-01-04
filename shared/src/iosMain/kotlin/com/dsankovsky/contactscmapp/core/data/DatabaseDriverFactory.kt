package com.dsankovsky.contactscmapp.core.data

import com.dsankovsky.contactscmapp.database.ContactDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {

    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            ContactDatabase.Schema,
            "contact.db"
        )
    }
}