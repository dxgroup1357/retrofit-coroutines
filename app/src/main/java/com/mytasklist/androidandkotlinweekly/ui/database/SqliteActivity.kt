package com.mytasklist.androidandkotlinweekly.ui.database

import com.androidandkotlinweekly.brinfotech.R
import com.androidandkotlinweekly.brinfotech.databinding.ActivitySqliteBinding
import com.mytasklist.androidandkotlinweekly.base.BaseActivity
import com.mytasklist.androidandkotlinweekly.ui.addevent.AddEventActivity
import com.mytasklist.androidandkotlinweekly.ui.viewevent.ViewEventActivity
import com.mytasklist.androidandkotlinweekly.viewextenstion.startNewActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SqliteActivity : BaseActivity<ActivitySqliteBinding, SqliteViewModel>() {
    override val layoutId: Int = R.layout.activity_sqlite

    override fun observeEvents() {

    }

    override fun init() {
        observeInvent()
    }

    private fun observeInvent() {
        viewModel.actionEvent.observe(this) {
            when (it) {

                is SqliteViewContract.OnAddEvent -> {
                    startNewActivity<AddEventActivity>{
                        this.putExtra("isFromAdd",true)
                    }
                }

                is SqliteViewContract.OnViewEvent -> {
                    startNewActivity<ViewEventActivity>()
                }

                else -> {}
            }
        }

    }
}