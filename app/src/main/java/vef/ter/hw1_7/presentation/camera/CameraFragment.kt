package vef.ter.hw1_7.presentation.camera

import android.os.Bundle
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
import vef.ter.hw1_7.presentation.utils.State
import vef.ter.hw1_7.utils.Swipe

@AndroidEntryPoint
class CameraFragment : BaseFragment<FragmentCameraBinding>() {
    private val adapter = CameraAdapter()
    private val viewModel: CameraViewModel by viewModels()


    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCameraBinding.inflate(inflater, container, false)


    override fun initView() {
        viewLifecycleOwner.lifecycleScope.launch { viewModel.getCameras() }
    }

    override fun initRV() {
        binding.rv.adapter = adapter
        val itemTouchHelper = ItemTouchHelper(object : Swipe(binding.rv) {
            override fun instantiateUnderlayButton(position: Int): List<Button> {
                val favoritesButton = favoritesButton()
                return listOf(favoritesButton)
            }
        })
        itemTouchHelper.attachToRecyclerView(binding.rv)


    }

    override fun initLiveData() {
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
                        adapter.addData(it.data?.data?.cameras!!)
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
            R.drawable.ic_fav
        )
    }
}
