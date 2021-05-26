package rs.myexample.hilt.data.repository

import rs.myexample.hilt.data.network.UsersApi
import rs.myexample.hilt.domain.IUserRepository
import rs.myexample.hilt.domain.base.BaseRepository
import rs.myexample.hilt.utils.Result
import javax.inject.Inject

class UserRepository
@Inject constructor(
    private val usersApi: UsersApi
) : BaseRepository(),
    IUserRepository {

    override suspend fun fetchUsers(page: Int): Result<Unit> =
      safeApiCall { usersApi.getUsers(page) }
          .applyIfSome { Result.Success() }
}