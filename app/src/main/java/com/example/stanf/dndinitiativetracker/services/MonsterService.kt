package com.example.stanf.ideaalduaal.services

import com.example.stanf.dndinitiativetracker.domain.Monster
import retrofit2.Call
import retrofit2.http.GET

interface MonsterService {
    @GET("monsters")
    fun getMonsters(): Call<List<Monster> >
}