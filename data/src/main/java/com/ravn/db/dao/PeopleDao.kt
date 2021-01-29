package com.ravn.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ravn.db.model.PeopleEntity

@Dao
interface PeopleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePeople(categories: List<PeopleEntity>): LongArray

    @Query("DELETE FROM PeopleEntity")
    suspend fun clearPeople(): Int

    @Query("SELECT * FROM PeopleEntity WHERE id=:peopleId")
    suspend fun getPeopleById(peopleId: String): PeopleEntity

    @Query("SELECT * FROM PeopleEntity")
    suspend fun getPeople(): MutableList<PeopleEntity>
}
