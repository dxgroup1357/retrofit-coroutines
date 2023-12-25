package com.mytasklist.androidandkotlinweekly.model

data class SignUpRequest(
    var email: String? = null,
    var name: String? = null,
    var password: String? = null
)

data class SIgnUpResponse(
    val id: String,
    val code: Int,
    val `data`: SingUpData? = null,
    val message: String
)

data class SingUpData(
    val id: String,
    val Email: String,
    val Id: Int,
    val Name: String,
    val Token: String
)

data class GetUserListResponse(
    var `$id`: String? = "",
    var `data`: List<GetUserData>? = listOf(),
    var page: Int? = 0,
    var per_page: Int? = 0,
    var total_pages: Int? = 0,
    var totalrecord: Int? = 0
)

data class GetUserData(
    var `$id`: String? = "",
    var createdat: String? = "",
    var email: String? = "",
    var id: Int? = 0,
    var location: String? = "",
    var name: String? = "",
    var profilepicture: String? = ""
)
data class AddUser(
    var email: String? = "",
    var location: String? = "",
    var name: String? = ""
)

