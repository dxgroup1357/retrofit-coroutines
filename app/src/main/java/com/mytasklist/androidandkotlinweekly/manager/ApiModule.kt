package com.mytasklist.androidandkotlinweekly.manager

import com.mytasklist.androidandkotlinweekly.repository.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)
}