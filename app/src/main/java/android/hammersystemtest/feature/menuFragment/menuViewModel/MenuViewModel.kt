package android.hammersystemtest.feature.menuFragment.menuViewModel

import android.hammersystemtest.domain.model.MealResponse
import android.hammersystemtest.domain.useCase.GetRandomMealUseCase
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val randomUseCase: GetRandomMealUseCase
): ViewModel() {

    val mealResponse: MutableLiveData<MealResponse> = MutableLiveData()

    init {
        getServiceResponse()
    }

    private fun getServiceResponse() = viewModelScope.launch {
        val response = randomUseCase.getRandomMeal()
        mealResponse.postValue(response)
        Log.e("ServiceResponse", response.toString())
    }
}