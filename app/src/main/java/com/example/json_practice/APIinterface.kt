package com.example.json_practice
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
interface APIinterface {

        @GET("/test/")
        fun getUser(): Call<Array<Users>>


    }
class Users ( var name: String) {

}

