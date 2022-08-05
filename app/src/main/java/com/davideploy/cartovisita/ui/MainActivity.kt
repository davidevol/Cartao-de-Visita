package com.davideploy.cartovisita.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.davideploy.cartovisita.App
import com.davideploy.cartovisita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListener()

    }

    private fun insertListener() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->

        }
    }

    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this, { businesCards ->
            adapter.submitList(businesCards)

        })
    }

}