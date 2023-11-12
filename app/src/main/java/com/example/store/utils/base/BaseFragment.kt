package com.example.store.utils.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.store.R
import com.example.store.utils.network.NetworkChecker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 28,October,2023,ArezouGhorbaniii@gmail.com**/
@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var networkChecker: NetworkChecker

    //Other
    var isNetworkAvailable = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Check network
        lifecycleScope.launch {
            networkChecker.checkNetwork().collect {
                isNetworkAvailable = it
                if (!it) {
                    Toast.makeText(requireContext(), R.string.checkYourNetwork, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}