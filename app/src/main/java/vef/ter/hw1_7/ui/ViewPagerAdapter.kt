package vef.ter.hw1_7.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import vef.ter.hw1_7.ui.camera.CameraFragment
import vef.ter.hw1_7.ui.door.DoorFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CameraFragment()
            1 -> DoorFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
