package com.mytasklist.androidandkotlinweekly.ui.database

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mytasklist.androidandkotlinweekly.apisecond.BoredResponse
import com.mytasklist.androidandkotlinweekly.ui.addevent.AddEventViewContract
import com.mytasklist.androidandkotlinweekly.utils.SingleLiveEvent
import kotlinx.coroutines.Job
import javax.inject.Inject

class SqliteViewModel @Inject constructor() : ViewModel() {

    val actionEvent: SingleLiveEvent<SqliteViewContract> = SingleLiveEvent()
    var job: Job? = null
    val errorMessage = MutableLiveData<String>()

    fun onAddEvent() {
        actionEvent.postValue(SqliteViewContract.OnAddEvent)
    }

    fun onViewEvent() {
        actionEvent.postValue(SqliteViewContract.OnViewEvent)
    }

    init {

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    private fun onError(message: String) {
        Log.d("myTag:", "Error:$message")
        errorMessage.value = message
    }

}