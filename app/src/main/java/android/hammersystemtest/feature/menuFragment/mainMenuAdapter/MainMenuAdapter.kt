package android.hammersystemtest.feature.menuFragment.mainMenuAdapter

import android.hammersystemtest.databinding.ItemFoodListBinding
import android.hammersystemtest.domain.model.MealResponseItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainMenuAdapter : RecyclerView.Adapter<MainMenuAdapter.MealViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<MealResponseItem>() {
        override fun areItemsTheSame(oldItem: MealResponseItem, newItem: MealResponseItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MealResponseItem, newItem: MealResponseItem) =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class MealViewHolder(private val binding: ItemFoodListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mealItem: MealResponseItem) {
            binding.apply {
                Picasso.get().load(mealItem.img).into(ivMealImage)
                tvTitle.text = mealItem.name
                tvDescription.text = mealItem.dsc
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