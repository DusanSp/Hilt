package rs.myexample.hilt.presentation.main.list

import rs.myexample.hilt.presentation.base.IIntent

sealed class UsersIntent : IIntent {
    object DownloadData : UsersIntent()
}