package com.mytasklist.androidandkotlinweekly.viewextenstion

import androidx.appcompat.widget.AppCompatEditText


fun AppCompatEditText.getEditTextValue(): String {
    return this.text.toString()
}