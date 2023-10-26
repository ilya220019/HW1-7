package vef.ter.hw1_7.ui.door

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vef.ter.hw1_7.core.model.DoorModelDTO
import vef.ter.hw1_7.databinding.ItemDoorBinding
import vef.ter.hw1_7.utils.loadImage


class DoorAdapter :
    RecyclerView.Adapter<DoorAdapter.DoorViewHolder>() {
    private var list = mutableListOf<DoorModelDTO.Data>()
    fun addData(doors: List<DoorModelDTO.Data>) {
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
        fun toBind(doorModel: DoorModelDTO.Data) {
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