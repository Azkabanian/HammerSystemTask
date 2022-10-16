package android.hammersystemtest.feature.menuFragment.mainMenuAdapter

import android.hammersystemtest.databinding.ItemFoodListBinding
import android.hammersystemtest.domain.model.MenuItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainMenuAdapter : RecyclerView.Adapter<MainMenuAdapter.MealViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<MenuItem>() {
        override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem) =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class MealViewHolder(private val binding: ItemFoodListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mealItem: MenuItem) {
            binding.apply {
                Picasso.get().load(mealItem.image).into(ivMealImage)
                tvTitle.text = mealItem.title
                tvDescription.text = mealItem.restaurantChain
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding = ItemFoodListBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)

        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {

        val currentItem = differ.currentList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = differ.currentList.size
}