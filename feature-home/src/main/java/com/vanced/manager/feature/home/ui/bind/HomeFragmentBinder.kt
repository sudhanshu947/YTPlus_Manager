package com.ytplus.manager.origin.feature.home.ui.bind

import android.util.Log
import androidx.lifecycle.coroutineScope
import com.ytplus.manager.origin.feature.home.databinding.FragmentHomeBinding
import com.ytplus.manager.origin.feature.home.presentation.HomeViewModel
import com.ytplus.manager.origin.feature.home.ui.HomeFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal fun HomeFragment.bindData(
    binding: FragmentHomeBinding,
    viewModel: HomeViewModel
) {
    viewModel.appsList.onEach {
        Log.d("apps", it.toString())
    }.launchIn(viewLifecycleOwner.lifecycle.coroutineScope)
}