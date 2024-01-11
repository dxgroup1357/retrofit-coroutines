package com.mytasklist.androidandkotlinweekly.apisecond

data class BoredResponse(
    var accessibility: Double? = 0.0,
    var activity: String? = "",
    var key: String? = "",
    var link: String? = "",
    var participants: Int? = 0,
    var price: Double? = 0.0,
    var type: String? = ""
)