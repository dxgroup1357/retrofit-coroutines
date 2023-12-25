package com.mytasklist.androidandkotlinweekly.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androidandkotlinweekly.brinfotech.databinding.ActivityMainBinding
import com.mytasklist.androidandkotlinweekly.ui.home.HomeActivity
import com.mytasklist.androidandkotlinweekly.manager.SessionManager
import com.mytasklist.androidandkotlinweekly.model.SignUpRequest
import com.mytasklist.androidandkotlinweekly.viewextenstion.getEditTextValue
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var moviesAdapter : MoviesRecyclerAdapter
    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewModel()
        binding.vm = viewModel


        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.responseContainer.observe(this, Observer {
            if (it != null) {
                it.data?.let {
                    sessionManager.setUserData(it)
                    sessionManager.setSessionToken(it.Token)
                    Log.d("myTag", "setSessionData")
                        startActivity(Intent(this, HomeActivity::class.java))
                }
            } else {
                Toast.makeText(this, "There is some error!", Toast.LENGTH_SHORT).show()
            }
        })
        initEvent()
    }

    private fun initEvent() {
        viewModel.actionEvent.observe(this){
            when(it){
                MainViewContract.OnSubmit -> {
                    SignUpRequest().apply {
                        name = binding.edtName.getEditTextValue()
                        email = binding.edtEmail.getEditTextValue()
                        password = binding.edtPassword.getEditTextValue()
                    }.also {
                        viewModel.getMoviesFromAPI(it)
                    }
                }
            }
        }
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}