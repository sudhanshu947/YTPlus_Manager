package com.ytplus.manager.origin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.preference.PreferenceManager.getDefaultSharedPreferences
import androidx.recyclerview.widget.LinearLayoutManager
import com.ytplus.manager.origin.R
import com.ytplus.manager.origin.adapter.SelectAppsAdapter
import com.ytplus.manager.origin.core.ui.base.BindingFragment
import com.ytplus.manager.origin.databinding.FragmentSelectAppsBinding
import com.ytplus.manager.origin.ui.WelcomeActivity

class SelectAppsFragment : BindingFragment<FragmentSelectAppsBinding>() {

    private lateinit var selectAdapter: SelectAppsAdapter

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSelectAppsBinding.inflate(inflater, container, false)

    override fun otherSetups() {
        bindData()
    }

    private fun bindData() {
        with(binding) {
            initRecycler()
            selectAppsFab.setOnClickListener { actionOnClickAppsFab() }
        }
    }

    private fun FragmentSelectAppsBinding.initRecycler() {
        selectAdapter = SelectAppsAdapter(requireActivity())
        selectAppsRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            setHasFixedSize(true)
            adapter = selectAdapter
        }
    }

    private fun actionOnClickAppsFab() {
        if (selectAdapter.apps.all { app -> !app.isChecked }) {
            Toast.makeText(requireActivity(), R.string.select_at_least_one_app, Toast.LENGTH_SHORT)
                .show()
            return
        }
        val prefs = getDefaultSharedPreferences(requireActivity())
        selectAdapter.apps.forEach { app ->
            prefs.edit { putBoolean("enable_${app.tag}", app.isChecked) }
        }
        (requireActivity() as WelcomeActivity).navigateTo(2)
    }
}