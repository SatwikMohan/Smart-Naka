package com.gigawattstechnology.smartnakakotlin

import com.google.gson.annotations.SerializedName

data class Doc(
    @SerializedName("VehiclePlateNumber")
    val VehiclePlateNumber:String,
    @SerializedName("VehicleHolderName")
    val VehicleHolderName:String,
    @SerializedName("VehicleCompanyModal")
    val VehicleCompanyModal:String
)
