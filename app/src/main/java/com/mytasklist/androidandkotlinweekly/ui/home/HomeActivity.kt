package com.mytasklist.androidandkotlinweekly.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.androidandkotlinweekly.brinfotech.databinding.ActivityHomeBinding
import com.mytasklist.androidandkotlinweekly.ui.bored.BoredActivity
import com.mytasklist.androidandkotlinweekly.ui.database.SqliteActivity
import com.mytasklist.androidandkotlinweekly.ui.designpatterndemo.DesignPatternActivity
import com.mytasklist.androidandkotlinweekly.ui.mapacitity.MapActivity
import com.mytasklist.androidandkotlinweekly.viewextenstion.startNewActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(){
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setContentView(binding.root)
        binding.vm = viewModel
        eventListener()
    }

    private fun eventListener() {
        viewModel.actionEvent.observe(this){
            when(it){
               is HomeViewContract.OnTextViewDemo-> {

                }

                is HomeViewContract.OnBoredActivityDemo-> {
                    startNewActivity<BoredActivity>()
                }

                is HomeViewContract.OnDesignPatternEvent-> {
                    startNewActivity<DesignPatternActivity>()
                }

                is HomeViewContract.OnSqliteEvent-> {
                    startNewActivity<SqliteActivity>()
                }

                is HomeViewContract.OnMapEvent-> {
                    startNewActivity<MapActivity>()
                }

                else -> {}
            }
        }
    }
}