package com.bayu07750.taskrecyclerview.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bayu07750.taskrecyclerview.R
import com.bayu07750.taskrecyclerview.databinding.ActivityHomeBinding
import com.bayu07750.taskrecyclerview.model.User
import com.bayu07750.taskrecyclerview.ui.detail.DetailActivity
import com.bayu07750.taskrecyclerview.utils.DataDummy

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: HomeAdapter
    private lateinit var dataUser: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.home)

        dataUser = DataDummy.getPhoto
        adapter = HomeAdapter(dataUser) { user ->
            Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.KEY_EXTRA_USER, user)
            }.also { startActivity(it) }
        }

        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        with(binding.recyclerview) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = this@HomeActivity.adapter
            addItemDecoration(
                DividerItemDecoration(
                    this@HomeActivity,
                    RecyclerView.VERTICAL
                )
            )
        }
    }
}