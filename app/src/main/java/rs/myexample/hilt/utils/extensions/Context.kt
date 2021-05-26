package rs.myexample.hilt.utils.extensions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import rs.myexample.hilt.presentation.base.BaseActivity
import rs.myexample.hilt.utils.Logger
import timber.log.Timber

inline fun <reified TargetActivityT : BaseActivity<*, *>> Context.navigateToActivity(bundle: Bundle? = null) {
    this.startActivity(Intent(this, TargetActivityT::class.java).apply {
        bundle?.let {
            putExtras(it)
        }
    })
}

fun Context.logDebug(message: String, vararg args: Any?) = Logger.debug(message, args)

fun Context.logInfo(message: String, vararg args: Any?) = Logger.info(message, args)

fun Context.logWarning(message: String, vararg args: Any?) = Logger.warning(message, args)

fun Context.logError(message: String, vararg args: Any?, throwable: Throwable? = null) =
    Logger.error(message, args, throwable)