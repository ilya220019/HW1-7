package vef.ter.hw1_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import vef.ter.hw1_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // Задайте заголовки для ваших вкладок
            when (position) {
                0 -> tab.text = "Tab 1"
                1 -> tab.text = "Tab 2"
            }
        }.attach()
        supportActionBar?.title = "Дом"


    }
}