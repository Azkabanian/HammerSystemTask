package android.hammersystemtest.data.api

import android.hammersystemtest.domain.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HammerSystemTestApi {

    @GET("pizzas")
    suspend fun getRandomMeal(): MealResponse
}