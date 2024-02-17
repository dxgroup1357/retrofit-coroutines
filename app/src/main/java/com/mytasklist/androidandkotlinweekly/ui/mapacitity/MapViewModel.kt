package com.mytasklist.androidandkotlinweekly.ui.mapacitity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

class MapViewModel @Inject constructor(val retrofitInstance: APIService) : ViewModel() {

    val actionEvent: SingleLiveEvent<MapViewContract> = SingleLiveEvent()
    val responseContainer = MutableLiveData<GetEntriesResponse>()
    var job: Job? = null

    fun onSubmit() {
        actionEvent.postValue(MapViewContract.OnTextViewDemo)
    }

    init {
        getMoviesFromAPI()
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun getMoviesFromAPI() {
        job = viewModelScope.launch {
            val response = retrofitInstance.getEntries()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    responseContainer.postValue(response.body())
                    //isShowProgress.value = false
                    Log.d("myTag:", "response:${response.body()?.count}")
                } else {
                    onError("Error : ${response.message()}")
                   // Log.d("myTag:", "response:${response}")
                }
            }
        }
    }


    private fun onError(message: String) {
        Log.d("myTag:", "Error:$message")
    }
}