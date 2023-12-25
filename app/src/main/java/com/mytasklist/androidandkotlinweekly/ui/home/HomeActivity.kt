package com.mytasklist.androidandkotlinweekly.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.androidandkotlinweekly.brinfotech.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(){
    private lateinit var activityMainBinding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setContentView(activityMainBinding.root)
        eventListener()
    }

    private fun eventListener() {
        viewModel.actionEvent.observe(this){
            when(it){
                HomeViewContract.OnTextViewDemo-> {

                }
            }
        }
    }
}