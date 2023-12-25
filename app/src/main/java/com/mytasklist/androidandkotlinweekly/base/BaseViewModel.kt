package com.mytasklist.androidandkotlinweekly.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/*
abstract class BaseViewModel: ViewModel() {
    private val _failure: MutableLiveData<SnapshotApplyResult.Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    protected fun handleFailure(failure: Failure) {
        _failure.value = failure
    }
}*/
