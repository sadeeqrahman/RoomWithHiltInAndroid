package com.encoders.sadeeq.roomwithhiltinandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.encoders.sadeeq.roomwithhiltinandroid.databinding.UserViewBinding

class UserListAdapter(val userList: List<UserEntity>,
    val userListInterface: UserListInterface)
    : RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
       val binding = UserViewBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false
       )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int
    ) {
       val currentUser = userList[position]
        holder.binding.apply {
            userName.text = currentUser.userName
            mobileNumber.text = currentUser.mobileNumber
        }
        holder.itemView.setOnClickListener {
            userListInterface.deleteUser(currentUser)
        }
    }

    override fun getItemCount(): Int {
        return  userList.size
    }


    inner class  UserViewHolder(val binding: UserViewBinding):
            RecyclerView.ViewHolder(binding.root)
}