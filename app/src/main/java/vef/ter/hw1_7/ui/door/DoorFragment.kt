package vef.ter.hw1_7.ui.door

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import vef.ter.hw1_7.R
import vef.ter.hw1_7.core.base.BaseFragment
import vef.ter.hw1_7.core.model.DoorModelDTO
import vef.ter.hw1_7.databinding.FragmentDoorBinding
import vef.ter.hw1_7.ui.mainActivity.MainActivity
import vef.ter.hw1_7.utils.Swipe


class DoorFragment : BaseFragment<FragmentDoorBinding>() {

    private val adapter = DoorAdapter()
    private val viewModel = DoorViewModel(MainActivity.repository)


    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDoorBinding.inflate(inflater, container, false)

    override fun initView() {
        viewModel.getDoors()
    }


    override fun initLiveData() {
        viewModel.doors.observe(viewLifecycleOwner) { doors ->
            initRV(doors.data)
        }
    }

    private fun initRV(doors: List<DoorModelDTO.Data>) {
        adapter.addData(doors)
        binding.rv.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(object : Swipe(binding.rv) {
            override fun instantiateUnderlayButton(position: Int): List<Button> {
                val editButton = editButton()
                val favoritesButton = favoritesButton()
                return listOf(editButton, favoritesButton)
            }
        })

        itemTouchHelper.attachToRecyclerView(binding.rv)
        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            if (loading) {
                binding.shimmerLayout.startShimmer()
                binding.shimmerLayout.visibility = View.VISIBLE
            } else {
                binding.shimmerLayout.stopShimmer()
                binding.shimmerLayout.visibility = View.GONE

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