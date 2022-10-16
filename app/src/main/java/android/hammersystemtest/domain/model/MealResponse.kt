package android.hammersystemtest.domain.model

data class MealResponse(
    val menuItems: List<MenuItem>,
    val number: Int,
    val offset: Int,
    val totalMenuItems: Int,
    val type: String
)