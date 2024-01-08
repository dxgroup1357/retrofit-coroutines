package com.mytasklist.androidandkotlinweekly.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM
    protected lateinit var binding: B
    protected lateinit var activity: AppCompatActivity

    abstract val layoutId: Int
    var weakReference: WeakReference<Context>?= null
    abstract fun observeEvents()
    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        weakReference = WeakReference(applicationContext)
        createViewModelBinding()
        init()
        observeEvents()
    }

    private fun createViewModelBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        binding.setVariable(BR.vm, viewModel)
    }

    fun getActivity(): Activity {
        return activity
    }

}