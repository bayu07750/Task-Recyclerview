package com.bayu07750.taskrecyclerview.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bayu07750.taskrecyclerview.R
import com.bayu07750.taskrecyclerview.databinding.ActivityDetailBinding
import com.bayu07750.taskrecyclerview.model.User
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class DetailActivity : AppCompatActivity() {

    companion object {
        internal const val KEY_EXTRA_USER = "key_extra_user"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detail)

        val user = intent.getParcelableExtra<User>(KEY_EXTRA_USER) ?: return

        setupView(user)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @SuppressLint("SetTextI18n")
    private fun setupView(user: User) {
        val (
            firstName,
            lastName,
            email,
            avatar
        ) = user

        with(binding) {
            Glide.with(this@DetailActivity)
                .load(avatar)
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageUser)

            textFullNameUser.text = "$firstName $lastName"
            textEmailUser.text = email
        }
    }
}