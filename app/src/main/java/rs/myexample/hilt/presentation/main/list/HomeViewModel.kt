package rs.myexample.hilt.presentation.main.list

import dagger.hilt.android.lifecycle.HiltViewModel
import rs.myexample.hilt.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor() : BaseViewModel<Nothing, Nothing>()
