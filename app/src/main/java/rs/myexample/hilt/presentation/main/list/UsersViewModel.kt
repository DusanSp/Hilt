package rs.myexample.hilt.presentation.main.list

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import rs.myexample.hilt.domain.FetchUsers
import rs.myexample.hilt.presentation.base.BaseViewModel
import rs.myexample.hilt.utils.Result
import javax.inject.Inject

@HiltViewModel
class UsersViewModel
@Inject constructor(
    fetchUsers: FetchUsers
) : BaseViewModel<UsersIntent, UsersState>() {

    init {
        viewModelScope.launch {
            val response = fetchUsers.invoke(1)
            withContext(Dispatchers.Main) {
                when (response) {
                    is Result.Error -> Log.d(UsersViewModel::class.java.simpleName, "Error")
                    is Result.Success -> Log.d(UsersViewModel::class.java.simpleName, "Success")
                }
            }
        }
    }

    @ExperimentalCoroutinesApi
    override suspend fun handleIntents(intent: UsersIntent) {
        when (intent) {
            UsersIntent.DownloadData -> setState(UsersState.ShowToast)
        }
    }
}