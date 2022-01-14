package com.sirdave.marvelcomicsapp.network

import com.google.gson.GsonBuilder
import com.sirdave.marvelcomicsapp.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder {
    fun provideCharacterService(): CharacterService{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CharacterService::class.java)
    }
}