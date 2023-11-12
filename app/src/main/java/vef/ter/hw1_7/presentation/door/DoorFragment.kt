package vef.ter.hw1_7.presentation.door

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import vef.ter.hw1_7.R
import vef.ter.hw1_7.core.base.BaseFragment
import vef.ter.hw1_7.databinding.FragmentCameraBinding
import vef.ter.hw1_7.databinding.FragmentDoorBinding
import vef.ter.hw1_7.presentation.utils.State
import vef.ter.hw1_7.utils.Swipe

@AndroidEntryPoint
class DoorFragment : BaseFragment<FragmentDoorBinding>() {
    private val viewModel: DoorViewModel by viewModels()


    private val adapter = DoorAdapter()

    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDoorBinding.inflate(inflater, container, false)

    override fun initView() {
        viewLifecycleOwner.lifecycleScope.launch { viewModel.getDoors() }
    }


    override fun initRecyclerView() {
        binding.rv.adapter = adapter
    }

    override fun initLiveData() {
        val itemTouchHelper = ItemTouchHelper(object : Swipe(binding.rv) {
            override fun instantiateUnderlayButton(position: Int): List<Button> {
                val editButton = editButton()
                val favoritesButton = favoritesButton()
                return listOf(editButton, favoritesButton)
            }
        })

        itemTouchHelper.attachToRecyclerView(binding.rv)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewState.collect {
                when (it) {
                    is State.Loading -> {
                        binding.shimmerLayout.startShimmer()
                        binding.shimmerLayout.visibility = View.VISIBLE
                    }

                    is State.Success -> {
                        binding.shimmerLayout.stopShimmer()
                        binding.shimmerLayout.visibility = View.GONE
                        adapter.addData(it.data!!.data)
                    }

                    is State.Error -> {
                        Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                    }

                    is State.Empty -> {
                        Toast.makeText(requireContext(), "Empty", Toast.LENGTH_SHORT).show()
                    }


                }
            }
        }
    }


    private fun favoritesButton(): Swipe.Button {
        return Swipe.Button(
            requireContext(),
            "Fav",
            20f,
            R.drawable.ic_fav,
        )
    }

    private fun editButton(): Swipe.Button {
        return Swipe.Button(
            requireContext(),
            "ED",
            20f,
            R.drawable.ic_edit
        )
    }

}