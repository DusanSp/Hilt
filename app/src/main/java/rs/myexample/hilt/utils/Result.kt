package rs.myexample.hilt.utils

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out DataT: Any> {

    /**
     * Success state.
     */
    data class Success<out DataT: Any>(val data: DataT? = null) : Result<DataT>()

    /**
     * ResultError state
     */
    data class Error(val throwable: Throwable? = null) : Result<Nothing>()

    fun ifSuccessGetDataOrNull(): DataT? = when (this is Success && data != null) {
        true -> this.data
        false -> null
    }

    suspend fun <OutT : Any> applyIfSome(block: suspend (DataT) -> Result<OutT>): Result<OutT> =
        when (this) {
            is Success -> ifSuccessGetDataOrNull()?.let { block(it) } ?: Success()
            is Error -> this
        }

    fun <OutT: Any> toResult(): Result<OutT> =
        when(this) {
            is Error -> Error()
            is Success -> Success()
        }
}