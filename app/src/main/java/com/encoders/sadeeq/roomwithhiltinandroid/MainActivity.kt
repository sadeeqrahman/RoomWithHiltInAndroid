package com.encoders.sadeeq.roomwithhiltinandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.encoders.sadeeq.roomwithhiltinandroid.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val roomDatabaseViewModel: RoomDatabaseViewModel by viewModels()
    private lateinit var userListAdapter: UserListAdapter
    private lateinit var _binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        _binding.userList.layoutManager = LinearLayoutManager(this)
        userListAdapter = UserListAdapter(listOf())

        lifecycleScope.launchWhenCreated {
            roomDatabaseViewModel.userList_.collect {
                userListAdapter = UserListAdapter(it)
                _binding.userList.adapter = userListAdapter
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