package rs.myexample.hilt.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import rs.myexample.hilt.data.network.model.PaginationRaw
import rs.myexample.hilt.data.network.model.UserRaw

interface UsersApi {

    @GET("users/")
    suspend fun getUsers(@Query("page") page: Int): Response<PaginationRaw<UserRaw>>
}