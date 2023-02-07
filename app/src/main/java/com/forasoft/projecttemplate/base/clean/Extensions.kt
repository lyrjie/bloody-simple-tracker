package com.forasoft.projecttemplate.base.clean

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

suspend operator fun <R> UseCase<Unit, R>.invoke() = this.invoke(Unit)
operator fun <R> FlowUseCase<Unit, R>.invoke() = this.invoke(Unit)
fun <R> Flow<Result<R>>.successes() = this.map { it.getOrThrow() }.catch { }
