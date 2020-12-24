package com.bayu07750.taskrecyclerview.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bayu07750.taskrecyclerview.databinding.ActivitySplashBinding
import com.bayu07750.taskrecyclerview.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }, 5000)
    }
}