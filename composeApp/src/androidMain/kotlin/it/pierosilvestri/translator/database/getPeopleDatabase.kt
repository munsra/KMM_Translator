package it.pierosilvestri.translator.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

/*
fun getPeopleDatabase(ctx: Context): PeopleDatabase {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("people.db")
    return Room.databaseBuilder<PeopleDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}

 */

fun getPeopleDatabase(ctx: Context): RoomDatabase.Builder<PeopleDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("people.db")
    return Room.databaseBuilder<PeopleDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}