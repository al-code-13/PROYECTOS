package com.example.rickandmorty.controlles.services

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

open class ServiceFactory {
    val routeBase: String = "https://rickandmortyapi.com/api"

    //Instancia de okHTTP para hacer las peticiones beibi

    private val client: OkHttpClient =
        OkHttpClient().newBuilder().build()


    //Unico metodo (GET)
    @Throws(IOException::class)
    fun get(url: String): Call {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        //Formamos la peticion y ahora se la pasamos al metodo encargado de que la realice <3
        return client.newCall(request)
    }
}