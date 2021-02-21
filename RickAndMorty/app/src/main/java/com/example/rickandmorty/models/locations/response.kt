package com.example.rickandmorty.models.locations

data class Locations (
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
    val type: String? = null,
    val dimension: String? = null,
    val residents: List<String>? = null,
    val url: String? = null,
    val created: String? = null
)