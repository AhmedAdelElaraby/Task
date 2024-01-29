package com.workdev.bigrewards.di

import com.workdev.bigrewards.Network.API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesUrl() ="https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun providesApiService(url:String) : API =
         Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)


}