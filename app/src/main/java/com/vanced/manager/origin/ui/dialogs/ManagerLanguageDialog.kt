package com.ytplus.manager.origin.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.preference.PreferenceManager.getDefaultSharedPreferences
import com.ytplus.manager.origin.BuildConfig.MANAGER_LANGUAGES
import com.ytplus.manager.origin.core.ui.base.BindingBottomSheetDialogFragment
import com.ytplus.manager.origin.databinding.DialogManagerLanguageBinding
import com.ytplus.manager.origin.ui.core.ThemedMaterialRadioButton
import com.ytplus.manager.origin.utils.checkedButtonTag
import com.ytplus.manager.origin.utils.getLanguageFormat
import com.ytplus.manager.origin.utils.managerLang

class ManagerLanguageDialog : BindingBottomSheetDialogFragment<DialogManagerLanguageBinding>() {

    companion object {

        fun newInstance(): ManagerLanguageDialog = ManagerLanguageDialog().apply {
            arguments = Bundle()
        }
    }

    private val prefs by lazy { getDefaultSharedPreferences(requireActivity()) }

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DialogManagerLanguageBinding.inflate(inflater, container, false)

    override fun otherSetups() {
        bindData()
    }

    private fun bindData() {
        with(binding) {
            addRadioButtons().forEach { mrb ->
                languageRadiogroup.addView(mrb, MATCH_PARENT, WRAP_CONTENT)
            }
            val language = prefs.managerLang
            root.findViewWithTag<ThemedMaterialRadioButton>(language)?.isChecked = true
            languageSave.setOnClickListener {
                val newPref = binding.languageRadiogroup.checkedButtonTag
                if (language != newPref) {
                    prefs.managerLang = newPref
                    dismiss()
                    requireActivity().recreate()
                } else {
                    dismiss()
                }
            }
        }
    }

    private fun addRadioButtons() =
        (arrayOf("System Default") + MANAGER_LANGUAGES).map { lang ->
            ThemedMaterialRadioButton(requireActivity()).apply {
                text = getLanguageFormat(requireActivity(), lang)
                textSize = 18f
                tag = lang
            }
        }
}