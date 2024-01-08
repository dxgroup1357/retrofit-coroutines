package com.mytasklist.androidandkotlinweekly.apisecond

import retrofit2.Response
import javax.inject.Inject

class BoredRepositoryImpl @Inject constructor(
    private val api:ApiServiceBored
):ApiServiceBored {
    override suspend fun getActivityList(): Response<BoredResponse> {
        return api.getActivityList()
    }

    override suspend fun getActivityKeys(keys:String?): Response<BoredResponse> {
        return api.getActivityKeys(keys)
    }
}