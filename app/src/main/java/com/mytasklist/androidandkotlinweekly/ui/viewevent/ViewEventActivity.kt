package com.mytasklist.androidandkotlinweekly.ui.viewevent

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidandkotlinweekly.brinfotech.R
import com.androidandkotlinweekly.brinfotech.databinding.ActivityViewEventBinding
import com.mytasklist.androidandkotlinweekly.adapter.CourseRVAdapter
import com.mytasklist.androidandkotlinweekly.base.BaseActivity
import com.mytasklist.androidandkotlinweekly.model.CourseModal
import com.mytasklist.androidandkotlinweekly.ui.addevent.AddEventActivity
import com.mytasklist.androidandkotlinweekly.ui.database.DBHandler
import com.mytasklist.androidandkotlinweekly.utils.OnRecyclerItemClickListener
import com.mytasklist.androidandkotlinweekly.viewextenstion.startNewActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ViewEventActivity : BaseActivity<ActivityViewEventBinding, ViewEventViewModel>(),
    OnRecyclerItemClickListener<CourseModal> {
    private var dbHandler: DBHandler? = null
    override val layoutId: Int = R.layout.activity_view_event
    private var cursorAdapter : CourseRVAdapter?= null
    private var arrayListCourse = ArrayList<CourseModal>()

    override fun observeEvents() {
        dbHandler = DBHandler(applicationContext)
    }

    override fun init() {
        dbHandler = DBHandler(weakReference?.get())
        getCourseList()
        initRcv()
        observeInvent()
    }

    private fun getCourseList() {
        arrayListCourse = dbHandler?.readCourses()!!
    }

    private fun initRcv() {
        cursorAdapter = CourseRVAdapter(arrayListCourse,applicationContext,this)
        binding.rcvViewEvent.apply {
            layoutManager = LinearLayoutManager(weakReference?.get(),RecyclerView.VERTICAL,false)
            setHasFixedSize(true)
            adapter = cursorAdapter
        }
    }

    private fun observeInvent() {
        viewModel.actionEvent.observe(this){
            when(it){
                ViewEventContract.OnAddEvent-> {
                    Toast.makeText(this, "Course has been added.", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    override fun onRecyclerItemClickListener(string: String, modelData: CourseModal) {
        startNewActivity<AddEventActivity> {
            this.putExtra("isFromAdd",false)
            this.putExtra("mydata",modelData)
        }
    }
}