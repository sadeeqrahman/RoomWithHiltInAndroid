package com.encoders.sadeeq.roomwithhiltinandroid

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM userTable")
    suspend fun usersList(): List<UserEntity>

    @Query("DELETE FROM userTable WHERE id = :id")
    suspend fun deleteUser(id: Int)



}