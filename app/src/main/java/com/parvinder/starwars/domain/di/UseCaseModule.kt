package com.parvinder.starwars.domain.di


import com.parvinder.starwars.data.usecase.GetCharactersUseCaseImpl
import com.parvinder.starwars.domain.usecase.GetCharactersUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun getCharactersUseCase(useCase: GetCharactersUseCaseImpl): GetCharactersUseCase


}