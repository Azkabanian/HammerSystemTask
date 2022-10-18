package android.hammersystemtest.domain.useCase

import android.hammersystemtest.data.api.HammerSystemTestApi
import android.hammersystemtest.domain.HammerSystemTestRepository
import javax.inject.Inject

class GetRandomMealUseCase @Inject constructor(
    private val api : HammerSystemTestApi
): HammerSystemTestRepository {

    override suspend fun getRandomMeal() = api.getRandomMeal()
}