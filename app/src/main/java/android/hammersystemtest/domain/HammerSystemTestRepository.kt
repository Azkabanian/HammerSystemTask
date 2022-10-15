package android.hammersystemtest.domain

import android.hammersystemtest.domain.model.FoodResponse

interface HammerSystemTestRepository {

    suspend fun getRandomFood(): FoodResponse
}