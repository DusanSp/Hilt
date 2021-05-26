package rs.myexample.hilt.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import rs.myexample.hilt.utils.SingleEvent
import timber.log.Timber

abstract class BaseViewModel<IntentT : IIntent, StateT : IState> : ViewModel() {

    private val intentChannel = Channel<IntentT>(Channel.UNLIMITED)

    @ExperimentalCoroutinesApi
    private val _state = MutableStateFlow<SingleEvent<StateT?>>(SingleEvent(null))

    @ExperimentalCoroutinesApi
    val state: StateFlow<SingleEvent<StateT?>>
        get() = _state

    init {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                handleIntents(intent)
            }
        }
    }

    open suspend fun handleIntents(intent: IntentT) {}

    fun setIntent(intent: IntentT) {
        intentChannel.offer(intent)
    }

    @ExperimentalCoroutinesApi
    protected fun setState(state: StateT) {
        _state.value = SingleEvent(state)
    }

    fun ViewModel.logDebug(message: String, vararg args: Any?) = Timber.d(message, args)

    fun ViewModel.logInfo(message: String, vararg args: Any?) = Timber.i(message, args)

    fun ViewModel.logWarning(message: String, vararg args: Any?) = Timber.w(message, args)

    fun ViewModel.logError(message: String, vararg args: Any?, throwable: Throwable? = null) =
        Timber.e(throwable, message, args)
}