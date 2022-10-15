package android.hammersystemtest.data.api

import android.hammersystemtest.domain.model.FoodResponse
import retrofit2.http.GET

interface HammerSystemTestApi {

    @GET("random.php")
    suspend fun getRandomFood(): FoodResponse
}