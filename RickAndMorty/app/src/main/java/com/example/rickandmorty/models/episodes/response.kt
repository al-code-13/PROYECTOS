package com.example.rickandmorty.models.episodes

data class Episodes (
    val info: Info? = null,
    val results: List<Result>? = null
)

data class Info (
    val count: Long? = null,
    val pages: Long? = null,
    val next: String? = null,
    val prev: Any? = null
)

data class Result (
    val id: Long? = null,
    val name: String? = null,
    val airDate: String? = null,
    val episode: String? = null,
    val characters: List<String>? = null,
    val url: String? = null,
    val created: String? = null
)