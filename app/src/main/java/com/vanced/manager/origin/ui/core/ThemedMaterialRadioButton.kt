package com.ytplus.manager.origin.ui.core

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import com.google.android.material.radiobutton.MaterialRadioButton
import com.ytplus.manager.origin.R
import com.ytplus.manager.origin.utils.accentColor

class ThemedMaterialRadioButton @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
) : MaterialRadioButton(context, attributeSet, R.attr.radioButtonStyle) {
    init {
        buttonTintList = ColorStateList.valueOf(accentColor.value!!)
    }
}