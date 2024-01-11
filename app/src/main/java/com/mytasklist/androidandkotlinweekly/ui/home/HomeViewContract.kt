package com.mytasklist.androidandkotlinweekly.ui.home

sealed class HomeViewContract {
object OnTextViewDemo: HomeViewContract();
object OnBoredActivityDemo: HomeViewContract()
object OnDesignPatternEvent: HomeViewContract()
object OnSqliteEvent: HomeViewContract()
}