package com.filipeoliveira.pocketmiibo.di

import com.filipeoliveira.pocketmiibo.data.AmiiboRepositoryImpl
import com.filipeoliveira.pocketmiibo.data.IAmiiboRepository
import com.filipeoliveira.pocketmiibo.data.remote.APIService
import com.filipeoliveira.pocketmiibo.data.remote.AmiiboRemoteDataSourceImpl
import com.filipeoliveira.pocketmiibo.data.remote.IAmiiboRemoteDataSource
import com.filipeoliveira.pocketmiibo.data.remote.RetrofitConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {

    @Provides
    @Singleton
    fun provideAPIService() : APIService {
        return RetrofitConfig.service
    }

    @Provides
    @Singleton
    fun provideAmiiboRemoteDataSource(apiService: APIService) : IAmiiboRemoteDataSource {
        return AmiiboRemoteDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideAmiiboRepository(remoteDataSource: IAmiiboRemoteDataSource) : IAmiiboRepository {
        return AmiiboRepositoryImpl(remoteDataSource)
    }
}