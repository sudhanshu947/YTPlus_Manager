package com.ytplus.manager.origin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ytplus.manager.origin.core.ui.base.BindingFragment
import com.ytplus.manager.origin.databinding.FragmentWelcomeBinding
import com.ytplus.manager.origin.ui.WelcomeActivity

class WelcomeFragment : BindingFragment<FragmentWelcomeBinding>() {

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentWelcomeBinding.inflate(inflater, container, false)

    override fun otherSetups() {
        bindData()
    }

    private fun bindData() {
        binding.welcomeGetStarted.setOnClickListener {
            (requireActivity() as WelcomeActivity).navigateTo(1)
        }
    }
}