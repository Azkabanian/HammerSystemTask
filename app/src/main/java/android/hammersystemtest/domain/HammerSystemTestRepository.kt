package android.hammersystemtest.domain

import android.hammersystemtest.domain.model.MealResponse

interface HammerSystemTestRepository {

    suspend fun getRandomMeal(): MealResponse
}