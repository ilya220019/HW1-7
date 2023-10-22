package vef.ter.hw1_7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vef.ter.hw1_7.databinding.ItemForCameraBinding
import vef.ter.hw1_7.utils.loadImage


class CameraAdapter(val list: ArrayList<new>) :
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
    fun resetItem(position: Int, viewHolder: RecyclerView.ViewHolder) {
        val itemView = viewHolder.itemView
        if (position != -1) {
            var position = -1
            notifyItemChanged(position)
        }
        notifyItemChanged(position)
    }
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.toBind(list[position])
    }

    inner class CameraViewHolder(private val binding: ItemForCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun toBind(item: new) {
            binding.tvCamera.text = item.title
            binding.imgCamera.loadImage(item.image)
        }
    }
}