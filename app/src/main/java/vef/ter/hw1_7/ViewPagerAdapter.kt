package vef.ter.hw1_7

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2 // Количество ваших фрагментов

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CameraFragment()
            1 -> DoorFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
