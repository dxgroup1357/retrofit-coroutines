package com.mytasklist.androidandkotlinweekly.model

data class GetEntriesResponse(
    var count: Int? = 0,
    var entries: List<GetEntriesData> = listOf()
)

data class GetEntriesData(
    var API: String? = "",
    var Auth: String? = "",
    var Category: String? = "",
    var Cors: String? = "",
    var Description: String? = "",
    var HTTPS: Boolean? = false,
    var Link: String? = ""
)