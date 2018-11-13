package com.example.stanf.ideaalduaal.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Maak een object van Servicebuilder zodat er maar 1 is in het volledige project (Singleton Pattern)
object ServiceBuilder {
    val URL = "http://www.dnd5eapi.co/api/"

    //retrofit builder
    val builder = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
    val retrofit = builder.build()

    //Helper om services te bouwen, instantieert klassen waarvan Retrofit de Interface doorgaf, zou moeten static komen
    fun <S> buildService(serviceType: Class<S>): S {
        return retrofit.create(serviceType)
    }
}