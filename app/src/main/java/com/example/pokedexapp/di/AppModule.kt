package com.example.pokedexapp.di

import com.example.pokedexapp.data.remote.PokeApi
import com.example.pokedexapp.repository.PokemonDataRepository
import com.example.pokedexapp.repository.PokemonRepository
import com.example.pokedexapp.util.Constants
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
    @Singleton
    @Provides
    fun providePokemonRepository(api: PokeApi): PokemonRepository = PokemonDataRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(): PokeApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokeApi::class.java)

}

