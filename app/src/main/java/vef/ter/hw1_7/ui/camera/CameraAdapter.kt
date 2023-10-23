package vef.ter.hw1_7.ui.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vef.ter.hw1_7.databinding.ItemForCameraBinding
import vef.ter.hw1_7.model.New
import vef.ter.hw1_7.utils.loadImage


class CameraAdapter(private val list: ArrayList<New>) :
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

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.toBind(list[position])
    }

    inner class CameraViewHolder(private val binding: ItemForCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun toBind(item: New) {
            binding.tvCamera.text = item.title
            binding.imgCamera.loadImage(item.image)
        }
    }
}