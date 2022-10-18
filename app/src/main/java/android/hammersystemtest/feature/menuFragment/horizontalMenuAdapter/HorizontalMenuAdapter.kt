package android.hammersystemtest.feature.menuFragment.horizontalMenuAdapter

import android.hammersystemtest.databinding.ItemFoodDiscountBinding
import android.hammersystemtest.domain.model.MealResponseItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class HorizontalMenuAdapter : RecyclerView.Adapter<HorizontalMenuAdapter.MealViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<MealResponseItem>() {
        override fun areItemsTheSame(oldItem: MealResponseItem, newItem: MealResponseItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MealResponseItem, newItem: MealResponseItem) =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class MealViewHolder(private val binding: ItemFoodDiscountBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mealItem: MealResponseItem) {
            binding.apply {
                Picasso.get().load(mealItem.img).into(ivMealImageHorizontal)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding = ItemFoodDiscountBinding
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