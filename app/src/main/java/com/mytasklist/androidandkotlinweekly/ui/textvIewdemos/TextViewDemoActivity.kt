package com.mytasklist.androidandkotlinweekly.ui.textvIewdemos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.androidandkotlinweekly.brinfotech.databinding.ActivityTextviewDemoBinding
import com.mytasklist.androidandkotlinweekly.ui.home.HomeViewContract
import com.mytasklist.androidandkotlinweekly.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TextViewDemoActivity : AppCompatActivity(){
    private lateinit var activityMainBinding: ActivityTextviewDemoBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityTextviewDemoBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setContentView(activityMainBinding.root)
        eventListener()
    }

    private fun eventListener() {
        viewModel.actionEvent.observe(this){
            when(it){
                HomeViewContract.OnTextViewDemo -> {

                }
                else -> {}
            }
        }
    }
}