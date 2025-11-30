package com.encoders.sadeeq.roomwithhiltinandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

@HiltViewModel
class RoomDatabaseViewModel
@Inject constructor(private val roomDatabaseRepository: RoomDatabaseRepository) :
    ViewModel() {

    val userList = MutableStateFlow<List<UserEntity>>(listOf())
    val userList_: StateFlow<List<UserEntity>> get() = userList

    fun getUsers() {
        try {
            viewModelScope.launch {
                userList.value = roomDatabaseRepository.getUsers()
            }
        } catch (e: Exception) {

        }
    }

    fun insertUser(userEntity: UserEntity) {
        viewModelScope.launch {
            try {
                roomDatabaseRepository.insertUser(userEntity)
                getUsers()
            } catch (e: kotlin.Exception) {

            }
        }
    }

    fun deleteUser(userId: Int) {
        try {
            viewModelScope.launch {
                roomDatabaseRepository.deleteUser(userId)
                getUsers()
            }
        } catch (e: kotlin.Exception) {

        }
    }

    fun updateUser(userEntity: UserEntity) {
        try {
            viewModelScope.launch {
                roomDatabaseRepository.updateUser(userEntity)
                getUsers()
            }
        } catch (e: kotlin.Exception) {

        }
    }

}