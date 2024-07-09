package com.example.pokedexapp.repository

import com.example.pokedexapp.data.remote.PokeApi
import com.example.pokedexapp.data.remote.response.Pokemon
import com.example.pokedexapp.data.remote.response.PokemonList
import com.example.pokedexapp.util.Resource
import javax.inject.Inject

class PokemonDataRepository @Inject constructor(private val pokeApi: PokeApi) : PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList> {
        val response = try {
            pokeApi.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(name: String) : Resource<Pokemon> {
        val response = try {
            pokeApi.getPokemonInfo(name)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }
}