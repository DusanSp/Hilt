package rs.myexample.hilt.domain.base

interface IParamUseCase<in InputTypeT, out OutputTypeT> {
    operator fun invoke(params: InputTypeT): OutputTypeT
}