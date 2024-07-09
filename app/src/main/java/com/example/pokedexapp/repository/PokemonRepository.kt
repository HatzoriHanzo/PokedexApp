package com.example.pokedexapp.repository

import com.example.pokedexapp.data.remote.response.Pokemon
import com.example.pokedexapp.data.remote.response.PokemonList
import com.example.pokedexapp.util.Resource

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList>
    suspend fun getPokemonInfo(name: String): Resource<Pokemon>
}