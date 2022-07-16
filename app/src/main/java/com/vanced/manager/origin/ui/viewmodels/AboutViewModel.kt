package com.ytplus.manager.origin.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ytplus.manager.origin.R
import com.ytplus.manager.origin.utils.openUrl

class AboutViewModel(application: Application) : AndroidViewModel(application) {

    fun openUrl(url: String) {
        openUrl(url, R.color.GitHub, getApplication())
    }

}