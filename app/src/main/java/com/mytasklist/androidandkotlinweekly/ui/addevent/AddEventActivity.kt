package com.mytasklist.androidandkotlinweekly.ui.addevent

import android.widget.Toast
import com.androidandkotlinweekly.brinfotech.R
import com.androidandkotlinweekly.brinfotech.databinding.ActivityAddEventBinding
import com.mytasklist.androidandkotlinweekly.base.BaseActivity
import com.mytasklist.androidandkotlinweekly.model.CourseModal
import com.mytasklist.androidandkotlinweekly.ui.database.DBHandler
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddEventActivity : BaseActivity<ActivityAddEventBinding, AddEventViewModel>() {
    private var dbHandler: DBHandler? = null
    override val layoutId: Int = R.layout.activity_add_event

    override fun observeEvents() {
        dbHandler = DBHandler(applicationContext)
    }

    override fun init() {
        getIntentData()
        observeInvent()
    }

    private fun getIntentData() {
        if (intent.hasExtra("isFromAdd")) {
            var isFromAdded = intent.getBooleanExtra("isFromAdd", false)
            if(!isFromAdded){
               val modelData:CourseModal? = intent.getSerializableExtra("mydata") as CourseModal
                if (modelData != null) {
                    setDetails(modelData)
                }
            }
        }
    }

    private fun setDetails(modelData: CourseModal) {
        binding.idEdtCourseName.setText(modelData.courseName)
        binding.idEdtCourseDescription.setText(modelData.courseDescription)
    }

    private fun observeInvent() {
        viewModel.actionEvent.observe(this) {
            when (it) {
                AddEventViewContract.OnAddEvent -> {

                    dbHandler?.addNewCourse(
                        binding.idEdtCourseName.text.toString(),
                        binding.idEdtCourseDuration.text.toString(),
                        binding.idEdtCourseDescription.text.toString(),
                        binding.idEdtCourseTracks.text.toString(),
                    )
                    Toast.makeText(this, "Course has been added.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}