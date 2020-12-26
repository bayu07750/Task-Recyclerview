package com.bayu07750.taskrecyclerview.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bayu07750.taskrecyclerview.databinding.ActivityHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonShowProgressbar.setOnClickListener {
            createDialog()
        }
    }

    private fun createDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Konfirmasi")
            .setMessage("Apakah anda ingin login?")
            .setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Ya") { dialog, _ ->
                Toast.makeText(this, "Silahkan tunggu Email dari kami", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .show()
    }
}