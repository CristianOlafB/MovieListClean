package com.example.data.util

import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

val passphrase: ByteArray = SQLiteDatabase.getBytes("olafPassword".toCharArray())
val factory = SupportFactory(passphrase)