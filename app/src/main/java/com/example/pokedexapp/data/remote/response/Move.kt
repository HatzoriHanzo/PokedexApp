package com.example.pokedexapp.data.remote.response

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)