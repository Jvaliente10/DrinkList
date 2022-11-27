package com.example.joseantoniovaliente.drinklist.model.server


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinkList(
    @SerializedName("drinks")
    val drinks: List<Drink>
) : Parcelable