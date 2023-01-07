package com.gigawattstechnology.smartnakakotlin

import com.google.gson.annotations.SerializedName

data class FindDoc(
    @SerializedName("_id")
    val id:String,
    @SerializedName("VehicleCompanyModal")
    val VehicleCompanyModal:String,
    @SerializedName("VehicleHolderName")
    val VehicleHolderName:String,
    @SerializedName("VehiclePlateNumber")
    val VehiclePlateNumber:String
)
