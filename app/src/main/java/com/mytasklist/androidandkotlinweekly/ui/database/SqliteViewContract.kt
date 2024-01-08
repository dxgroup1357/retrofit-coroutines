package com.mytasklist.androidandkotlinweekly.ui.database


sealed class SqliteViewContract {
object OnAddEvent: SqliteViewContract();
object OnViewEvent: SqliteViewContract();
}