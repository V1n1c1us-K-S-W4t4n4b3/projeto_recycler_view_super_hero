package com.kzdev.projetohero.network

import com.kzdev.projetohero.model.SuperHero
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("all.json")
    fun getAll() : Call<List<SuperHero>>
}