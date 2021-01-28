package com.ravn.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ravn.db.dao.PeopleDao
import com.ravn.db.model.PeopleEntity

@Database(
    entities = [
        PeopleEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
}