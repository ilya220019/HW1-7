package vef.ter.hw1_7.presentation.door

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vef.ter.hw1_7.databinding.ItemDoorBinding
import vef.ter.hw1_7.domain.model.DoorModel
import vef.ter.hw1_7.utils.loadImage


class DoorAdapter :
    RecyclerView.Adapter<DoorAdapter.DoorViewHolder>() {
    private var list = mutableListOf<DoorModel.Data>()
    fun addData(doors: List<DoorModel.Data>) {
        list.clear()
        list.addAll(doors)
        notifyItemRangeInserted(list.size, doors.size - list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorViewHolder {
        return DoorViewHolder(
            ItemDoorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.toBind(list[position])


    }

    inner class DoorViewHolder(private val binding: ItemDoorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun toBind(doorModel: DoorModel.Data) {
            binding.tvDoor.text = doorModel.name
            if (binding.card.visibility == View.GONE) {
                binding.cardOne.setOnClickListener { binding.card.visibility = View.VISIBLE }
            }
            binding.card.setOnClickListener { binding.card.visibility = View.GONE }
            binding.imgDetail.loadImage(doorModel.snapshot)
            binding.imgDel.setOnClickListener {
                list.removeAt(position)
                notifyDataSetChanged()
            }
        }

    }
}