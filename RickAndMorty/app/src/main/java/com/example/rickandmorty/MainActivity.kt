package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rickandmorty.models.system.SystemResponse
import com.example.rickandmorty.presenters.HomePresenter
import com.example.rickandmorty.presenters.HomeUI


// tienes que extender de la interfaz HomeUI para que abajo te deje colorcar el this, this
class MainActivity : AppCompatActivity(),HomeUI {

    //Le hacemos referencia al HomePresenter de que aca es donde tiene que renderizar las 3 interfaces
    private val presenter = HomePresenter(this,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getAllSystem()
    }

    //El te va a arrojar un error en MainActivity hasta que no implementes los miembros faltantes que
    // son las interfaces que hayas creado

    //Si todoo salio correcto entra a esta interfaz y en data esta la rta del servicio
    override fun showHome(data: SystemResponse) {
        Log.i("la data de la vista",data.toString())
    }
    //Aca puedes mostrar un speen de carga mientras llega la data
    override fun showLoad() {
        Log.i("la data de la vista","data.toString(")
    }
    //Y esto es por si hace booms
    override fun showError(error: String) {
        TODO("Not yet implemented")
    }
}