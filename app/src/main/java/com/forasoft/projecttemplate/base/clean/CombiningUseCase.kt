package com.forasoft.projecttemplate.base.clean

import kotlinx.coroutines.CoroutineDispatcher

abstract class CombiningUseCase<in P, R>(
    coroutineDispatcher: CoroutineDispatcher,
) : UseCase<P, R>(coroutineDispatcher) {

    protected suspend fun <CP, CR> runChild(useCase: UseCase<CP, CR>, parameters: CP): CR =
        useCase.invoke(parameters).getOrThrow()

    protected suspend fun <CR> runChild(useCase: UseCase<Unit, CR>): CR = runChild(useCase, Unit)

}
