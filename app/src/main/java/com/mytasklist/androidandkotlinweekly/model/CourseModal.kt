package com.mytasklist.androidandkotlinweekly.model

import java.io.Serializable


class CourseModal(
    var courseName: String="",
    var courseDuration: String="",
    var courseTracks: String="",
    var courseDescription: String="",
    var id:Int=0,
): Serializable
