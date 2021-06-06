package com.app.kotlinapi.network

import Json4Kotlin_Base
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST("astro_data")
    fun getUserData(@Field("cat_id")  cat_id: String):
            Call<Json4Kotlin_Base >
}