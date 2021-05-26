package rs.myexample.hilt.utils

data class ErrorResult(
    val code: Int?,
    val throwable: Throwable?,
    val message: String?
)