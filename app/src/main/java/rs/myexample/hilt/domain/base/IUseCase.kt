package rs.myexample.hilt.domain.base

interface IUseCase<out OutputTypeT> {
    suspend operator fun invoke(): OutputTypeT
}