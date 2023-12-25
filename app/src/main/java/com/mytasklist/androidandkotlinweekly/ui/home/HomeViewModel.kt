package com.mytasklist.androidandkotlinweekly.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytasklist.androidandkotlinweekly.model.AddUser
import com.mytasklist.androidandkotlinweekly.model.GetUserListResponse
import com.mytasklist.androidandkotlinweekly.model.SignUpRequest
import com.mytasklist.androidandkotlinweekly.repository.APIService
import com.mytasklist.androidandkotlinweekly.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val retrofitInstance: APIService) : ViewModel() {

    val actionEvent: SingleLiveEvent<HomeViewContract> = SingleLiveEvent()
    val responseContainer = MutableLiveData<GetUserListResponse>()
    var job: Job? = null

    fun onSubmit() {
        actionEvent.postValue(HomeViewContract.OnTextViewDemo)
    }

    init {
        //getMoviesFromAPI()
        addUsers()
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun getMoviesFromAPI() {
        job = viewModelScope.launch {
            val response = retrofitInstance.getAllUser("1")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    responseContainer.postValue(response.body())
                    //isShowProgress.value = false
                    Log.d("myTag:", "response:${response}")
                } else {
                    onError("Error : ${response.message()}")
                   // Log.d("myTag:", "response:${response}")
                }
            }
        }
    }

    fun addUsers() {
         AddUser().apply {
             email = "test78@mailsac.com"
             location = "Surat"
             name = "Shri Ram"
         }.also {
             job = viewModelScope.launch {
                 val response = retrofitInstance.addUser(it)

                 withContext(Dispatchers.Main) {
                     if (response.isSuccessful) {
                         responseContainer.postValue(response.body())
                         //isShowProgress.value = false
                         Log.d("myTag:", "response:${response}")
                     } else {
                         onError("Error : ${response.message()}")
                         // Log.d("myTag:", "response:${response}")
                     }
                 }
             }
         }
    }

    private fun onError(message: String) {
        Log.d("myTag:", "Error:$message")
    }
}