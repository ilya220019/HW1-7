package vef.ter.hw1_7.ui.door

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vef.ter.hw1_7.databinding.ItemDoorBinding
import vef.ter.hw1_7.model.New
import vef.ter.hw1_7.utils.loadImage


class DoorAdapter(private val list: ArrayList<New>) :
    RecyclerView.Adapter<DoorAdapter.DoorViewHolder>() {
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
        fun toBind(item: New) {
            binding.tvDoor.text = item.title
            if (binding.card.visibility == View.GONE) {
                binding.cardOne.setOnClickListener { binding.card.visibility = View.VISIBLE }
            }
            binding.card.setOnClickListener { binding.card.visibility = View.GONE }
            binding.imgDetail.loadImage(item.image)
        }
    }
}