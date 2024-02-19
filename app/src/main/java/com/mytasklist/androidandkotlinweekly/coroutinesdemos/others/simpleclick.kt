package com.example.androidmaterialdesign.coroutinesdemos.others

interface OnClickListener {
    fun onClick()
}
fun setOnClickListener(listener: OnClickListener) {
    listener.onClick()
}
fun main() {
    setOnClickListener(object : OnClickListener {
        override fun onClick() {
            println("Button clicked")
        }
    })
}