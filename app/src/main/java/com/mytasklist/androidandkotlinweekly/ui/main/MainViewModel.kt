package com.mytasklist.androidandkotlinweekly.ui.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytasklist.androidandkotlinweekly.model.SIgnUpResponse
import com.mytasklist.androidandkotlinweekly.model.SignUpRequest
import com.mytasklist.androidandkotlinweekly.repository.APIService
import com.mytasklist.androidandkotlinweekly.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class MainViewModel @Inject constructor( val retrofitInstance: APIService) : ViewModel() {

    val responseContainer = MutableLiveData<SIgnUpResponse>()
    val errorMessage = MutableLiveData<String>()
    val isShowProgress = MutableLiveData<Boolean>()
    val expressionToSearch = MutableLiveData("")
    val actionEvent: SingleLiveEvent<MainViewContract> = SingleLiveEvent()

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled : ${throwable.localizedMessage}")
    }

    fun onSubmit() {
        actionEvent.postValue(MainViewContract.OnSubmit)
    }

    fun getMoviesFromAPI(signUpRequest: SignUpRequest) {
        isShowProgress.value = true
        job = viewModelScope.launch {
            val response = retrofitInstance.registerUser(signUpRequest)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    responseContainer.postValue(response.body())
                    isShowProgress.value = false
                } else {
                    onError("Error : ${response.message()}")
                    Log.d("myTag:", "response:${response}")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        isShowProgress.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}