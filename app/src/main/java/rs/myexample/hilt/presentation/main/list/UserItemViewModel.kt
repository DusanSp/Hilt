package rs.myexample.hilt.presentation.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserItemViewModel(
    private val item: UserItemView
) : ViewModel() {

    val userItem: LiveData<UserItemView> = MutableLiveData<UserItemView>().apply {
        value = item
    }
}