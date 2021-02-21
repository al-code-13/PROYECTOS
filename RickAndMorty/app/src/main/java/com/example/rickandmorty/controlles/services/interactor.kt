package com.example.rickandmorty.controlles.services

import android.util.Log
import com.example.rickandmorty.models.system.SystemResponse
import com.google.gson.GsonBuilder
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException


class ServiceInteractor : ServiceFactory() {

    fun getSystem(
        then:(SystemResponse)-> Unit,
        error:(String) -> Unit
    ) {
        val url = "$routeBase"
        get(url).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response){
                //Obtenemos solamente la informacion que necesitamos que siempre es el body
                val body= response.body?.string()
                //Lo parseamos de un string a un JSON
                val gson = GsonBuilder().create()
                //Le damos la "forma" con nuestro modelo de datos
                val res= gson.fromJson(body, SystemResponse::class.java)
                if (response.isSuccessful){
                    Log.i("body",body)
                    then(res)
                }
                else{
                    Log.i("MI ERROR","ALGO ANDA MAL")
                    error("SE toteo pero te quiero mamol")
                }

            }

            override fun onFailure(call: Call,e: IOException){

            }

        })
    }


}