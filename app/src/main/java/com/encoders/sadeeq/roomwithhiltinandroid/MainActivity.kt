package com.encoders.sadeeq.roomwithhiltinandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import com.encoders.sadeeq.roomwithhiltinandroid.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val roomDatabaseViewModel: RoomDatabaseViewModel by viewModels()
    private lateinit var _binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lifecycleScope.launchWhenCreated {
            roomDatabaseViewModel.userList_.collect {
                _binding.userlist.text = it.joinToString("\n") {
                    "${it.userName} - ${it.mobileNumber}"
                }
            }
        }

        roomDatabaseViewModel.getUsers()

        _binding.saveUser.setOnClickListener {
            roomDatabaseViewModel.insertUser(
                UserEntity(
                    userName = _binding.userName.text.toString(),
                    mobileNumber = _binding.mobileNumber.text.toString()
                )
            )
        }

        _binding.deleteUser.setOnClickListener {
            roomDatabaseViewModel.deleteUser(_binding.mobileNumber.text.toString().toInt())
        }

    }
}