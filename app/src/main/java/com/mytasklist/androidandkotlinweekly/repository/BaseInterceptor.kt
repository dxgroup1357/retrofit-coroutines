package com.mytasklist.androidandkotlinweekly.repository

import android.util.Log
import com.mytasklist.androidandkotlinweekly.manager.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class BaseInterceptor(
    private val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        builder.apply {
            /* addHeader("Accept-Language", Helper.getDeviceLocalLanguage())
               addHeader("deviceId", Helper.getDeviceId(context))
               addHeader("appVersion", sessionManager.getAppVersion())
               addHeader("osVersion", Build.MODEL + " " + Build.VERSION.RELEASE)
               addHeader("Accept", "application/json")
               addHeader("Content-Type", "application/json")
               addHeader("os", "android")
               addHeader("cache-control", "no-cache")*/
            if (sessionManager.checkPreferenceKey(SessionManager.ACCESS_TOKEN)) {
                if (!sessionManager.getAccessToken().isNullOrEmpty()) {
                    val token = sessionManager.getAccessToken()
                    addHeader("Content-Type", "application/json")
                    addHeader("Accept", "application/json")
                    addHeader("Authorization", "Bearer $token")
                    Log.d("myTag","token:$token")
                }
            }
        }

        val response = chain.proceed(builder.build())
        return response
    }
}