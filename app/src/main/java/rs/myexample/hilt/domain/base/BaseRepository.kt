package rs.myexample.hilt.domain.base

import retrofit2.HttpException
import retrofit2.Response
import rs.myexample.hilt.utils.Result

abstract class BaseRepository {

    protected suspend inline fun <DataT : Any> safeApiCall(
        crossinline apiCall: suspend () -> Response<DataT>
    ): Result<DataT> =
        try {
            val response = apiCall()
            if (response.isSuccessful) Result.Success(response.body())
            else Result.Error(HttpException(response))
        } catch (e: Exception) {
            Result.Error(e)
        }
}