package com.mytasklist.androidandkotlinweekly.ui.bored

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytasklist.androidandkotlinweekly.apisecond.ApiServiceBored
import com.mytasklist.androidandkotlinweekly.apisecond.BoredResponse
import com.mytasklist.androidandkotlinweekly.model.GetEntriesResponse
import com.mytasklist.androidandkotlinweekly.model.GetUserListResponse
import com.mytasklist.androidandkotlinweekly.repository.APIService
import com.mytasklist.androidandkotlinweekly.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BoredViewModel @Inject constructor(val retrofitInstance: ApiServiceBored) : ViewModel() {

    val actionEvent: SingleLiveEvent<BoredViewContract> = SingleLiveEvent()
    val responseContainer = MutableLiveData<BoredResponse>()
    val responseActivityKeys = MutableLiveData<BoredResponse>()
    var job: Job? = null
    val errorMessage = MutableLiveData<String>()
    fun onSubmit() {
        actionEvent.postValue(BoredViewContract.OnTextViewDemo)
    }

    init {
        getActivityList()
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

   private fun getActivityList() {
        job = viewModelScope.launch {
            val response = retrofitInstance.getActivityList()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    responseContainer.postValue(response.body())
                    //isShowProgress.value = false
                    Log.d("myTag:", "response:${response.body()?.accessibility}")
                } else {
                    onError("Error : ${response.message()}")
                   // Log.d("myTag:", "response:${response}")
                }
            }
        }
    }

     fun getActivityKeys(keys:String){
        job = viewModelScope.launch {
            val response = retrofitInstance.getActivityKeys(keys)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    responseActivityKeys.postValue(response.body())
                    //isShowProgress.value = false
                    Log.d("myTag:", "response:${response.body()?.accessibility}")
                } else {
                    onError("Error : ${response.message()}")
                    // Log.d("myTag:", "response:${response}")
                }
            }
        }
    }


    private fun onError(message: String) {
        Log.d("myTag:", "Error:$message")
        errorMessage.value = message
    }

}