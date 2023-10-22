package vef.ter.hw1_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vef.ter.hw1_7.databinding.FragmentDoorBinding


class DoorFragment : Fragment() {

    private lateinit var binding: FragmentDoorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoorBinding.inflate(inflater, container,false)
        return binding.root
    }

}