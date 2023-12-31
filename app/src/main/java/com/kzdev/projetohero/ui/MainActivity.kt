package com.kzdev.projetohero.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kzdev.projetohero.databinding.ActivityMainBinding
import com.kzdev.projetohero.model.SuperHero
import com.kzdev.projetohero.network.Endpoint
import com.kzdev.projetohero.network.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun setUpRecyclerView(dataSet: List<SuperHero>) {

        val rvHero = binding.rvHero

        rvHero.layoutManager = LinearLayoutManager(this)
        rvHero.adapter = SuperHeroAdapter(dataSet)

    }

    private fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://akabab.github.io/superhero-api/api/")

        val endPoint = retrofitClient.create(Endpoint::class.java)
        val callback = endPoint.getAll()

        // enqueue = enfileirar
        callback.enqueue(object : Callback<List<SuperHero>> {
            override fun onFailure(call: Call<List<SuperHero>>, t: Throwable) {
                Toast.makeText(baseContext, t.message,Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(
                call: Call<List<SuperHero>>,
                response: Response<List<SuperHero>>,
            ) {
                Log.i("Test", "ok")


                // com o ?.let tenho certesa q passa uma lista msm q vazia
                response.body()?.let {// qm chamar aqui?
                    setUpRecyclerView(it)
                }
            }

        })
    }
}