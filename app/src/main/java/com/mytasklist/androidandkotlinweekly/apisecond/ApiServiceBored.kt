package com.mytasklist.androidandkotlinweekly.apisecond

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceBored {
    @GET("activity")
    suspend fun getActivityList(): Response<BoredResponse>

    @GET("activity?")
    suspend fun getActivityKeys(
        @Query("key") keys: String?
    ): Response<BoredResponse>
}