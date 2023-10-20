package com.kzdev.projetohero.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {

        /** Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         * peixe ele nada igual ao q eu entendi !!!
         */
        fun getRetrofitInstance(path : String) : Retrofit {
            return Retrofit.Builder()

                // colocar url no path
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}