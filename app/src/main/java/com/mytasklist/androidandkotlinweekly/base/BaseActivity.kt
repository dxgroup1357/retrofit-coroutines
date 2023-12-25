package com.mytasklist.androidandkotlinweekly.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM
    protected lateinit var binding: B
    protected lateinit var activity: AppCompatActivity

    abstract val layoutId: Int

    abstract fun observeEvents()
    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        createViewModelBinding()
        init()
        observeEvents()
    }

    private fun createViewModelBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
       // binding.setVariable(BR.vm, viewModel)
    }

}