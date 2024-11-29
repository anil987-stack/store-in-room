package com.android.store_in_room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val gender: String,
    val address: String
)