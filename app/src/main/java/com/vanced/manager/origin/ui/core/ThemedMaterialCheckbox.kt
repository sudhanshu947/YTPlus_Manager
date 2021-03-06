package com.ytplus.manager.origin.ui.core

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import com.google.android.material.checkbox.MaterialCheckBox
import com.ytplus.manager.origin.R
import com.ytplus.manager.origin.utils.accentColor

class ThemedMaterialCheckbox @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
) : MaterialCheckBox(context, attributeSet, R.attr.checkboxStyle) {
    init {
        buttonTintList = ColorStateList.valueOf(accentColor.value!!)
    }
}