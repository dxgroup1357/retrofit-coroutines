package com.mytasklist.androidandkotlinweekly.repository

import com.mytasklist.androidandkotlinweekly.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface APIService {
    @POST("authaccount/registration")
    suspend fun registerUser(
        @Body request: SignUpRequest
    ): Response<SIgnUpResponse>

    @GET("users?")
    suspend fun getAllUser(
        @Query("page") page: String?
    ): Response<GetUserListResponse>

    @POST("users")
    suspend fun addUser(@Body request: AddUser): Response<GetUserListResponse>

    @GET("entries")
    suspend fun getEntries(): Response<GetEntriesResponse>

}