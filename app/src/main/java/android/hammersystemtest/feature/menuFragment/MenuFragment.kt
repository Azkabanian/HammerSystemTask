package android.hammersystemtest.feature.menuFragment

import android.hammersystemtest.databinding.FragmentMenuBinding
import android.hammersystemtest.feature.baseFragment.BaseFragment
import android.hammersystemtest.feature.menuFragment.horizontalMenuAdapter.HorizontalMenuAdapter
import android.hammersystemtest.feature.menuFragment.mainMenuAdapter.MainMenuAdapter
import android.hammersystemtest.feature.menuFragment.menuViewModel.MenuViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    private val viewModel by viewModels<MenuViewModel>()
    private lateinit var mainMenuAdapter: MainMenuAdapter
    private lateinit var horizontalMenuAdapter: HorizontalMenuAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMainRecyclerView()
        initHorizontalRecyclerView()

        viewModel.mealResponse.observe(viewLifecycleOwner) {
            mainMenuAdapter.differ.submitList(it.toList())
        }

        viewModel.mealResponse.observe(viewLifecycleOwner) {
            horizontalMenuAdapter.differ.submitList(it.toList())
        }
    }

    private fun initMainRecyclerView() {
        mainMenuAdapter = MainMenuAdapter()
        with(binding.rvFoodList) {
            layoutManager = LinearLayoutManager(activity)
            adapter = mainMenuAdapter
        }
    }

    private fun initHorizontalRecyclerView() {
        horizontalMenuAdapter = HorizontalMenuAdapter()
        with(binding.rvFoodListHorizontal) {
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            adapter = horizontalMenuAdapter
        }
    }

    private fun initActionBar() {

    }

}