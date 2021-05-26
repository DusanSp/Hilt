package rs.myexample.hilt.utils

import timber.log.Timber

object Logger {

    fun debug(message: String, vararg args: Any?) = Timber.d(message, args)

    fun info(message: String, vararg args: Any?) = Timber.i(message, args)

    fun warning(message: String, vararg args: Any?) = Timber.w(message, args)

    fun error(message: String, vararg args: Any?, throwable: Throwable? = null) =
        Timber.e(throwable, message, args)
}