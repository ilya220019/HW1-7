package vef.ter.hw1_7.presentation.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vef.ter.hw1_7.databinding.ItemForCameraBinding
import vef.ter.hw1_7.domain.model.CameraModel
import vef.ter.hw1_7.utils.loadImage


class CameraAdapter() :
    RecyclerView.Adapter<CameraAdapter.CameraViewHolder>() {
    private var list = mutableListOf<CameraModel.Data.Camera>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        return CameraViewHolder(
            ItemForCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    fun addData(cameras: List<CameraModel.Data.Camera>) {
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
        fun toBind(item: CameraModel.Data.Camera) {
            binding.tvCamera.text = item.name
            binding.imgCamera.loadImage(item.snapshot)
            binding.imgDel.setOnClickListener {
                list.removeAt(position)
                notifyDataSetChanged()
            }
        }
    }
}