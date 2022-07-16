package com.ytplus.manager.origin.ui.core

import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ytplus.manager.origin.R
import com.ytplus.manager.origin.utils.accentColor

class ThemedSwipeRefreshlayout @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : SwipeRefreshLayout(context, attributeSet) {
    init {
        setColorSchemeColors(accentColor.value!!)
        initAttrs(context, attributeSet)
    }

    private fun initAttrs(context: Context, attributeSet: AttributeSet?) {
        attributeSet.let {
            val typedAttrs =
                context.obtainStyledAttributes(it, R.styleable.ThemedSwipeRefreshlayout, 0, 0)
            setProgressBackgroundColorSchemeColor(
                typedAttrs.getColor(
                    R.styleable.ThemedSwipeRefreshlayout_progressBackgroundColor,
                    0
                )
            )
            typedAttrs.recycle()
        }
    }
}