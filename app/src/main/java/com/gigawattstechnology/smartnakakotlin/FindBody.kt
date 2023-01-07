package com.gigawattstechnology.smartnakakotlin

import com.google.gson.annotations.SerializedName

data class FindBody(
    @SerializedName("dataSource")
    val dataSource:String,
    @SerializedName("database")
    val database:String,
    @SerializedName("collection")
    val collection:String,
    @SerializedName("filter")
    val filter:FilterDoc
)
