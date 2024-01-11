package com.mytasklist.androidandkotlinweekly.ui.addevent

import androidx.lifecycle.ViewModel
import com.mytasklist.androidandkotlinweekly.utils.SingleLiveEvent
import kotlinx.coroutines.Job
import javax.inject.Inject

class AddEventViewModel @Inject constructor() : ViewModel() {

    val actionEvent: SingleLiveEvent<AddEventViewContract> = SingleLiveEvent()
    var job: Job? = null
    fun onAddEvent() {
        actionEvent.postValue(AddEventViewContract.OnAddEvent)
    }

    init {

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}