package com.example.joseantoniovaliente.drinklist.model.server

import com.example.joseantoniovaliente.drinklist.model.DetailsList
import com.example.joseantoniovaliente.drinklist.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CocktailDbService {

    @GET("filter.php?a=Alcoholic")
    suspend fun drinkList(): DrinkList

    @GET("lookup.php?")
    suspend fun getDetails(@Path("i")idDrink:String):DetailsList
}
