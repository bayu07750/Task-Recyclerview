package com.bayu07750.taskrecyclerview.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bayu07750.taskrecyclerview.R
import com.bayu07750.taskrecyclerview.databinding.ActivityHomeBinding
import com.bayu07750.taskrecyclerview.ui.fragments.ChatFragment
import com.bayu07750.taskrecyclerview.ui.fragments.StatusFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = arrayOf(ChatFragment(), StatusFragment())
        val adapter = HomePagerAdapter(fragments, supportFragmentManager, lifecycle)

        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabs, binding.viewPager2) { tab, position ->
            tab.text = getPageTitle(position)
        }.attach()
    }

    private fun getPageTitle(position: Int): String? {
        return when (position) {
            0 -> getString(R.string.chat)
            1 -> getString(R.string.status)
            else -> null
        }
    }
}