package com.mytasklist.androidandkotlinweekly.manager

import android.content.Context
import android.content.SharedPreferences
import com.androidandkotlinweekly.brinfotech.R
import com.google.gson.reflect.TypeToken
import com.mytasklist.androidandkotlinweekly.model.SIgnUpResponse
import com.mytasklist.androidandkotlinweekly.model.SingUpData
import com.mytasklist.androidandkotlinweekly.utils.SharedPreferenceHelper

@SuppressWarnings("unused")
class SessionManager constructor(context: Context){
    private val preferences: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    private val editor = preferences.edit()

    fun checkPreferenceKey(keyName: String): Boolean {
        return preferences.contains(keyName)
    }

    fun removePreferenceKey(keyName: String) {
        editor.remove(keyName)
    }

    fun clearPreferenceData() {
        editor.clear()
        editor.apply()
    }

    fun setUserData(paymentAccount: SingUpData) {
        editor.putString(
            USER_DATA,
            SharedPreferenceHelper.getStringFromObject(paymentAccount)
        )
        editor.apply()
    }

    fun getUserData(): SingUpData? {
        return SharedPreferenceHelper.getObjectFromString(preferences.getString(
            USER_DATA,
            ""
        ) ?: "", object : TypeToken<SingUpData>() {})
    }

    fun setSessionToken(token:String){
        editor.putString(ACCESS_TOKEN, token).apply()
    }

    fun getAccessToken(): String? {
        return preferences.getString(ACCESS_TOKEN, null)
    }

    companion object {
        // Define Key
        const val IS_USER_LOGIN = "is_user_login"
        const val ACCESS_TOKEN = "access_token"
        const val DEVICE_TOKEN = "device_token"
        const val USER_DATA = "user_data"
    }
}