package com.encoders.sadeeq.roomwithhiltinandroid

import javax.inject.Inject

class RoomDatabaseRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun insertUser(userEntity: UserEntity){
        userDao.insertUser(userEntity)
    }

    suspend fun deleteUser(userId: Int){
        userDao.deleteUser(userId)
    }

    suspend fun getUsers(): List<UserEntity>{
        return userDao.usersList()
    }
}