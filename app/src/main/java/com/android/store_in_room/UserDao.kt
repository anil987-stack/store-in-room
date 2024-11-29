package com.android.store_in_room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserModel)

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<UserModel>
}