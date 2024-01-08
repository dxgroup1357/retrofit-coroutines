package com.mytasklist.androidandkotlinweekly.ui.bored

import android.widget.Toast
import androidx.lifecycle.Observer
import com.androidandkotlinweekly.brinfotech.R
import com.androidandkotlinweekly.brinfotech.databinding.ActivityBoredBinding
import com.mytasklist.androidandkotlinweekly.apisecond.BoredResponse
import com.mytasklist.androidandkotlinweekly.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoredActivity : BaseActivity<ActivityBoredBinding, BoredViewModel>() {
    override val layoutId: Int = R.layout.activity_bored

    override fun observeEvents() {

    }

    override fun init() {
        observeInvent()
    }

    private fun observeInvent() {

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.responseContainer.observe(this, Observer {
            if (it != null) {
                setDetails(it)
                it.key?.let { it1 -> viewModel.getActivityKeys(it1) }
            } else {
                Toast.makeText(this, "There is some error!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setDetails(response: BoredResponse) {
        val responseString = buildString {
            appendLine(response.activity)
            appendLine(response.accessibility)
            appendLine(response.participants)
            appendLine(response.type)
            appendLine(response.price)
            appendLine(response.key)
        }

        binding.txtBored.text = responseString
    }
}