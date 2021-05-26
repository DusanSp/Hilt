package rs.myexample.hilt.presentation.main.list

import rs.myexample.hilt.presentation.base.IState

sealed class UsersState : IState {
    object ShowToast : UsersState()
}