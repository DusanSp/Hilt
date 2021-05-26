package rs.myexample.hilt.utils

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class SingleEvent<out DataT>(private val content: DataT) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getDataOrNull(): DataT? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): DataT = content
}