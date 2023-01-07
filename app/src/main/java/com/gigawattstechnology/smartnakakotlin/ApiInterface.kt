package com.gigawattstechnology.smartnakakotlin

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers(
        "api-key:epdSUFMZKmIyjemVuAutuvFqVWUDUDvYdYPMUuGY3nJqQwrRJJFa2a1uuz6gHVzm",
        "Content-Type:application/json"
    )
    @POST("action/insertOne")
    fun insertTask(@Body body: DataBody):Call<DataBody>
    @Headers(
        "api-key:epdSUFMZKmIyjemVuAutuvFqVWUDUDvYdYPMUuGY3nJqQwrRJJFa2a1uuz6gHVzm",
        "Content-Type:application/json"
    )
    @POST("action/findOne")
    fun findTask(@Body body:FindBody):Call<JsonObject>
}