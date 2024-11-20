package com.parvinder.starwars.domain.di

import com.parvinder.starwars.data.repo.StarWarDataRepoImpl
import com.parvinder.starwars.data.repo.StarWarsRepoImpl
import com.parvinder.starwars.domain.repo.StarWarDataRepo
import com.parvinder.starwars.domain.repo.StarWarsRepo
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
    abstract fun getStarWarDataRepo(repoImpl: StarWarDataRepoImpl): StarWarDataRepo

    @Binds
    @Singleton
    abstract fun getStarWarRepo(repoImpl: StarWarsRepoImpl): StarWarsRepo
}