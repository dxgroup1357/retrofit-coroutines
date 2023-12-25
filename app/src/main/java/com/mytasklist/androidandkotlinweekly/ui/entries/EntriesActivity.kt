package com.mytasklist.androidandkotlinweekly.ui.entries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.androidandkotlinweekly.brinfotech.databinding.ActivityEntriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EntriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEntriesBinding
    private lateinit var viewModel: EntriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntriesBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[EntriesViewModel::class.java]
        setContentView(binding.root)
    }
}