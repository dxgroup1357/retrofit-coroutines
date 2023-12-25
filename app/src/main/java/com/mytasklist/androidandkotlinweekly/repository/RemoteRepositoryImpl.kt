package com.mytasklist.androidandkotlinweekly.repository

import com.mytasklist.androidandkotlinweekly.model.*
import retrofit2.Response
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val api: APIService,
) :APIService{
    override suspend fun registerUser(request: SignUpRequest): Response<SIgnUpResponse> {
        return api.registerUser(request)
    }

    override suspend fun getAllUser(page: String?): Response<GetUserListResponse> {
        return api.getAllUser(page)
    }

    override suspend fun addUser(request: AddUser): Response<GetUserListResponse> {
        return api.addUser(request)
    }

    override suspend fun getEntries(): Response<GetEntriesResponse> {
         return api.getEntries()
    }

}