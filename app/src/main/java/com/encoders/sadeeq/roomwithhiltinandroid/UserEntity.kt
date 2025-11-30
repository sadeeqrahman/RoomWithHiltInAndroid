package com.encoders.sadeeq.roomwithhiltinandroid

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val userName: String,
    @ColumnInfo val mobileNumber: String
)