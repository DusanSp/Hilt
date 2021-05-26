package rs.myexample.hilt.domain

import rs.myexample.hilt.domain.base.BaseUseCase
import rs.myexample.hilt.domain.base.ISuspendParamUseCase
import rs.myexample.hilt.utils.Result
import javax.inject.Inject

class FetchUsers
@Inject constructor(
    private val repository: IUserRepository
) : BaseUseCase(),
    ISuspendParamUseCase<Int, Result<Unit>> {
    override suspend fun invoke(params: Int): Result<Unit> =
        repository.fetchUsers(params)
}