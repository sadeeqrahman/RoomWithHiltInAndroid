package com.encoders.sadeeq.roomwithhiltinandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.encoders.sadeeq.roomwithhiltinandroid.databinding.UserViewBinding

class UserListAdapter(
    val usersList: List<UserEntity>
) : RecyclerView.Adapter<UserListAdapter.UserViewModel>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewModel {
      val binding = UserViewBinding.inflate(
          LayoutInflater.from(parent.context),
          parent,
          false
      )
        return UserViewModel(binding)
    }

    override fun onBindViewHolder(
        holder: UserViewModel,
        position: Int
    ) {
       val user = usersList[position]
        holder.binding.apply {
            userName.text = user.userName
            mobileNumber.text = user.mobileNumber
        }
    }

    override fun getItemCount(): Int {
       return  usersList.size
    }

    inner class UserViewModel(val binding: UserViewBinding):
            RecyclerView.ViewHolder(binding.root)
}