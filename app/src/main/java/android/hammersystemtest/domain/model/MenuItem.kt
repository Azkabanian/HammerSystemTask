package android.hammersystemtest.domain.model

data class MenuItem(
    val id: Int,
    val image: String,
    val imageType: String,
    val restaurantChain: String,
    val servings: Servings,
    val title: String
)