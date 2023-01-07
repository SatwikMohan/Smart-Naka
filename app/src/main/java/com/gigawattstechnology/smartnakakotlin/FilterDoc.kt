package com.gigawattstechnology.smartnakakotlin

import com.google.gson.annotations.SerializedName

data class FilterDoc(
    @SerializedName("VehiclePlateNumber")
    val VehiclePlateNumber:String
)
