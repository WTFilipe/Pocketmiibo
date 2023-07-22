package com.filipeoliveira.pocketmiibo.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    var service: APIService = getAPIService()

    private fun getRetrofitBuild() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.amiiboapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun getAPIService() : APIService {
        return getRetrofitBuild().create(APIService::class.java)
    }

}