package com.example.joseantoniovaliente.drinklist.model.server

import retrofit2.http.GET


interface CocktailDbService {

    @GET("filter.php?a=Alcoholic")
    suspend fun drinkList():DrinkList
    @GET("")
    suspend fun
}
