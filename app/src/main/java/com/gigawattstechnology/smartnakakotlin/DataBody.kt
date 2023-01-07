package com.gigawattstechnology.smartnakakotlin

import com.google.gson.annotations.SerializedName

data class DataBody(
    @SerializedName("dataSource")
    val dataSource:String,
    @SerializedName("database")
    val database:String,
    @SerializedName("collection")
    val collection:String,
    @SerializedName("document")
    val document:Doc
)
