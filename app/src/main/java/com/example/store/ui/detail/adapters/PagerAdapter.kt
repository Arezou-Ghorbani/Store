package com.example.store.ui.detail.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.store.ui.detail_features.DetailFeaturesFragment
import com.example.store.ui.detail_chart.DetailChartFragment
import com.example.store.ui.detail_comments.DetailCommentsFragment

/**Created by Arezou-Ghorbani on 09,November,2023,ArezouGhorbaniii@gmail.com**/

class PagerAdapter(manager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(manager, lifecycle) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DetailCommentsFragment()
            1 -> DetailFeaturesFragment()
            else -> DetailChartFragment()
        }
    }
}