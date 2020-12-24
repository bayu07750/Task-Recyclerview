package com.bayu07750.taskrecyclerview.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bayu07750.taskrecyclerview.databinding.ItemUserBinding
import com.bayu07750.taskrecyclerview.model.User
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class HomeAdapter(
    private val listUser: List<User>,
    private val itemClicked: (User) -> Unit
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    inner class HomeViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .circleCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageUser)
                textFirstName.text = user.firstName
                constraintLayout.setOnClickListener {
                    itemClicked(user)
                }
            }
        }
    }
}