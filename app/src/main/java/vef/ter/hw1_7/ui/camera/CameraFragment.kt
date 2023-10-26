package vef.ter.hw1_7.ui.camera

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import vef.ter.hw1_7.R
import vef.ter.hw1_7.core.base.BaseFragment
import vef.ter.hw1_7.core.model.CameraModelDTO
import vef.ter.hw1_7.databinding.FragmentCameraBinding
import vef.ter.hw1_7.ui.mainActivity.MainActivity
import vef.ter.hw1_7.utils.Swipe


class CameraFragment : BaseFragment<FragmentCameraBinding>() {
    private val adapter = CameraAdapter()
    private val viewModel = CameraViewModel(MainActivity.repository)

    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCameraBinding.inflate(inflater, container, false)

    override fun initView() {
        viewModel.getCameras()
    }

    private fun initRV(cameras: List<CameraModelDTO.Data.Camera>) {
        adapter.addData(cameras = cameras)
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
        viewModel.cameras.observe(viewLifecycleOwner) { cameras ->
            initRV(cameras.data.cameras)
            binding.shimmerLayout.visibility = View.GONE
        }
        viewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            binding.shimmerLayout.visibility = View.GONE
        }
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
            R.drawable.ic_fav
        )
    }
}
