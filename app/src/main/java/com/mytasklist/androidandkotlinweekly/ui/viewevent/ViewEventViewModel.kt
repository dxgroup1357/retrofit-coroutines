package com.mytasklist.androidandkotlinweekly.ui.viewevent

import androidx.lifecycle.ViewModel
import com.mytasklist.androidandkotlinweekly.utils.SingleLiveEvent
import kotlinx.coroutines.Job
import javax.inject.Inject

class ViewEventViewModel @Inject constructor() : ViewModel() {

    val actionEvent: SingleLiveEvent<ViewEventContract> = SingleLiveEvent()
    var job: Job? = null
    fun onAddEvent() {
        actionEvent.postValue(ViewEventContract.OnAddEvent)
    }

    init {

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}