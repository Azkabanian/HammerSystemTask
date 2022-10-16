package android.hammersystemtest.data.api

import android.hammersystemtest.domain.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HammerSystemTestApi {

    @GET("/food/menuItems/search")
    suspend fun getRandomMeal(
        @Query("apiKey")
        apiKey: String = "616c6ab4f27d4429bce1ce84b09f242c",
        @Query("query")
        meal: String = "snickers",
        @Query("number")
        number: Int = 10
    ): MealResponse
}