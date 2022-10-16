package android.hammersystemtest.data.repository

import android.hammersystemtest.data.api.HammerSystemTestApi
import android.hammersystemtest.domain.HammerSystemTestRepository
import android.hammersystemtest.domain.model.MealResponse
import javax.inject.Inject

class HammerSystemTestRepositoryImpl @Inject constructor(
    private val api : HammerSystemTestApi
): HammerSystemTestRepository {
    override suspend fun getRandomMeal() = api.getRandomMeal()


}