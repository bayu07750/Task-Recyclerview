package com.bayu07750.taskrecyclerview.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bayu07750.taskrecyclerview.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}