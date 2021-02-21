package com.example.rickandmorty.presenters

import android.content.Context
import android.util.Log
import com.example.rickandmorty.models.system.SystemResponse

//Creamos la interfaz que creemos que sea pertinente para nuestro proyecto
interface HomeUI {
    //Como necesitamos enviar datos desde el presentador a la vista lo definimos aca
    fun showHome(data: SystemResponse)
    fun showLoad()
    fun showError(error: String)
}

//Extendemos de una clase que hicimos que se llama BasePresenter para escribir interactor y poder
//acceder a cada uno de sus metodos

class HomePresenter(val context: Context, private val ui: HomeUI) : BasePresenter() {

    fun getAllSystem() {
        try {

            //Mientras trae la data mostramos el speen de carga
            ui.showLoad()
            //Creamos una funcion lambda lo que significa que data solo existe y servira entre los
            // corchetes que la contienen y es la que tiene la respuesta del servidor
            interactor.getSystem({ data ->
                //Despues de que ya existe data ahora si mostramos el Home con la data disponible
                ui.showHome(data)
            }, {
                //Aca detonamos la pantalla de error por si algo hace booms eje un 404
                    error -> ui.showError("BOOMS $error") }
            )
        } catch (e: Exception) {
            Log.i("hizo booms getAllSystem", "Te quelo")
        }


    }
}