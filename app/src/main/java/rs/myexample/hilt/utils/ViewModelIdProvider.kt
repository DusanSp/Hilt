package rs.myexample.hilt.utils

object ViewModelIdProvider {

    var viewModelId: Int? = null
        get() = field ?: throw RuntimeException("ViewModelIdProvider not initialized")

}