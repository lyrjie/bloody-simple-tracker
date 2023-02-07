package com.lyrjie.bloodysimpletracker.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(@Suppress("unused") val dispatcher: AppDispatchers)

enum class AppDispatchers { IO }
