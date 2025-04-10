package com.mxverse.bhagvadgeeta.di.modules

import com.mxverse.bhagvadgeeta.data.repository.ApiRepositoryImpl
import com.mxverse.bhagvadgeeta.data.repository.AuthRepositoryImpl
import com.mxverse.bhagvadgeeta.domain.repository.ApiRepository
import com.mxverse.bhagvadgeeta.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNetworkApiRepository(
        impl: ApiRepositoryImpl
    ): ApiRepository

    @Binds
    @Singleton
    abstract fun bindAuthApiRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository
}
