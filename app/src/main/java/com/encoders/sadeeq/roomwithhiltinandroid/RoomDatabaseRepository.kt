package com.encoders.sadeeq.roomwithhiltinandroid

import androidx.lifecycle.LiveData
import javax.inject.Inject

class RoomDatabaseRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun insertUser(userEntity: UserEntity){
        userDao.insertUser(userEntity)
    }

    suspend fun deleteUser(userId: Int){
        userDao.deleteUser(userId)
    }

     fun getUsers(): LiveData<List<UserEntity>>{
        return userDao.usersList()
    }

    suspend fun updateUser(userEntity: UserEntity){
        userDao.updateUser(userEntity)

    }
}