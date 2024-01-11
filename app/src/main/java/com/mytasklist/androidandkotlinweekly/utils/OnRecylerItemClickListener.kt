package com.mytasklist.androidandkotlinweekly.utils

interface OnRecyclerItemClickListener<E> {
    fun onRecyclerItemClickListener(string: String,modelData:E)
}