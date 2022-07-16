package com.ytplus.manager.origin.ui.dialogs

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.ytplus.manager.origin.BuildConfig.VERSION_CODE
import com.ytplus.manager.origin.R
import com.ytplus.manager.origin.core.ui.base.BindingDialogFragment
import com.ytplus.manager.origin.databinding.DialogManagerUpdateBinding
import com.ytplus.manager.origin.utils.DownloadHelper.downloadManager
import com.ytplus.manager.origin.utils.applyAccent
import com.ytplus.manager.origin.utils.currentDownload
import com.ytplus.manager.origin.utils.downloadProgress
import com.ytplus.manager.origin.utils.manager

class ManagerUpdateDialog : BindingDialogFragment<DialogManagerUpdateBinding>() {

    companion object {

        const val CLOSE_DIALOG = "CLOSE_DIALOG"
        private const val TAG_FORCE_UPDATE = "TAG_FORCE_UPDATE"

        fun newInstance(
            forceUpdate: Boolean
        ): ManagerUpdateDialog = ManagerUpdateDialog().apply {
            arguments = Bundle().apply {
                putBoolean(TAG_FORCE_UPDATE, forceUpdate)
            }
        }
    }

    private val localBroadcastManager by lazy { LocalBroadcastManager.getInstance(requireActivity()) }

    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                CLOSE_DIALOG -> dismiss()
            }
        }
    }

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DialogManagerUpdateBinding.inflate(inflater, container, false)

    override fun otherSetups() {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        bindData()
        if (arguments?.getBoolean(TAG_FORCE_UPDATE) == true) {
            binding.managerUpdatePatient.text =
                requireActivity().getString(R.string.please_be_patient)
            downloadManager(requireActivity())
        } else {
            checkUpdates()
        }
    }

    private fun bindData() {
        with(binding) {
            isCancelable = false
            managerUpdateProgressbar.applyAccent()
            managerUpdateCancel.setOnClickListener {
                downloadProgress.value = 0
                currentDownload?.cancel()
                dismiss()
            }
            bindDownloadProgress()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun DialogManagerUpdateBinding.bindDownloadProgress() {
        downloadProgress.observe(viewLifecycleOwner) {
            managerUpdateProgressbar.progress = it
            managerUpdateProgressbarContainer.isVisible = it != 0
            managerUpdateProgress.text = "$it%"
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver()
    }

    override fun onPause() {
        super.onPause()
        localBroadcastManager.unregisterReceiver(broadcastReceiver)
    }

    private fun checkUpdates() {
        if (manager.value?.int("versionCode") ?: 0 > VERSION_CODE) {
            binding.managerUpdatePatient.text =
                requireActivity().getString(R.string.please_be_patient)
            downloadManager(requireActivity())
        } else {
            binding.managerUpdatePatient.text =
                requireActivity().getString(R.string.update_not_found)
        }
    }

    private fun registerReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(CLOSE_DIALOG)
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter)
    }
}
