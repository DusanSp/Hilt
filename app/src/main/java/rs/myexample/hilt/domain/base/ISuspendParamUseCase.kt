package rs.myexample.hilt.domain.base

interface ISuspendParamUseCase<in InputTypeT, out OutputTypeT> {
    suspend operator fun invoke(params: InputTypeT): OutputTypeT
}