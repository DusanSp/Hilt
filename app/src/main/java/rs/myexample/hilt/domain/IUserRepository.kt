package rs.myexample.hilt.domain

import rs.myexample.hilt.utils.Result

interface IUserRepository {

    suspend fun fetchUsers(page: Int): Result<Unit>
}