package com.example.rickandmorty.presenters

import com.example.rickandmorty.controlles.services.ServiceInteractor

open class BasePresenter{

    protected val interactor= ServiceInteractor()

}