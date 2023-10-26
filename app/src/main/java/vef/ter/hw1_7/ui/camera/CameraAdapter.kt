package vef.ter.hw1_7.ui.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vef.ter.hw1_7.core.model.CameraModelDTO
import vef.ter.hw1_7.databinding.ItemForCameraBinding
import vef.ter.hw1_7.utils.loadImage


class CameraAdapter() :
    RecyclerView.Adapter<CameraAdapter.CameraViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        return CameraViewHolder(
            ItemForCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private var list = mutableListOf<CameraModelDTO.Data.Camera>()

    fun addData(cameras: List<CameraModelDTO.Data.Camera>) {
        list.clear()
        list.addAll(cameras)
        notifyItemRangeInserted(list.size, cameras.size - list.size)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.toBind(list[position])
    }

    inner class CameraViewHolder(private val binding: ItemForCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun toBind(item: CameraModelDTO.Data.Camera) {
            binding.tvCamera.text = item.name
            binding.imgCamera.loadImage(item.snapshot)
            binding.imgDel.setOnClickListener {
                list.removeAt(position)
                notifyDataSetChanged()
            }
        }
    }
}