package com.sirdave.marvelcomicsapp.di

import com.google.gson.GsonBuilder
import com.sirdave.marvelcomicsapp.db.AppDatabase
import com.sirdave.marvelcomicsapp.db.dao.FavouriteDao
import com.sirdave.marvelcomicsapp.network.CharacterService
import com.sirdave.marvelcomicsapp.repository.CharacterRepository
import com.sirdave.marvelcomicsapp.repository.CharacterRepositoryImpl
import com.sirdave.marvelcomicsapp.util.CharacterDtoMapper
import com.sirdave.marvelcomicsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCharacterMapper(): CharacterDtoMapper {
        return CharacterDtoMapper()
    }

    @Singleton
    @Provides
    fun provideCharacterService(): CharacterService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CharacterService::class.java)
    }


    @Singleton
    @Provides
    @Named("time_stamp")
    fun provideTimestamp(): String {
        return Constants.TIMESTAMP
    }

    @Singleton
    @Provides
    @Named("apikey")
    fun provideApiKey(): String{
        return Constants.API_KEY
    }

    @Singleton
    @Provides
    @Named("hash")
    fun provideHash(): String{
        return Constants.hash()
    }

}