package com.encoders.sadeeq.roomwithhiltinandroid

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM userTable")
     fun usersList(): LiveData<List<UserEntity>>

    @Query("DELETE FROM userTable WHERE id = :id")
    suspend fun deleteUser(id: Int)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(userEntity: UserEntity)

}