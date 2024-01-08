package com.mytasklist.androidandkotlinweekly.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidandkotlinweekly.brinfotech.databinding.ActivityHomeBinding
import com.androidandkotlinweekly.brinfotech.databinding.ActivitySplashBinding
import com.mytasklist.androidandkotlinweekly.manager.SessionManager
import com.mytasklist.androidandkotlinweekly.ui.entries.EntriesActivity
import com.mytasklist.androidandkotlinweekly.ui.home.HomeActivity
import com.mytasklist.androidandkotlinweekly.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity(){
    private lateinit var activityMainBinding: ActivitySplashBinding

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        runBlocking {
            delay(3000)
            checkSession()
        }

    }

    private fun checkSession() {
       /* if(sessionManager.getUserData()?.Token?.isNotEmpty()==true){
            startActivity(Intent(this, HomeActivity::class.java))
        }else{
            startActivity(Intent(this, MainActivity::class.java))
        }
        */
        startActivity(Intent(this, HomeActivity::class.java))
    }
}