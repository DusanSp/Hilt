package rs.myexample.hilt.utils

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

private const val FILE_NAME = "test.txt"

class ReleaseTree
@Inject constructor() : Timber.Tree() {

    @ExperimentalCoroutinesApi
    @Inject
    lateinit var fileLogger: FileLogger

    @ExperimentalCoroutinesApi
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR || priority == Log.WARN) {
            if (::fileLogger.isInitialized) {
                CoroutineScope(Dispatchers.IO).launch {
                    fileLogger.writeMessage(FILE_NAME, "$tag/$message")
                }
            }
        }
    }
}