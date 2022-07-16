package com.ytplus.manager.origin.core.downloader

import android.content.Context
import com.ytplus.manager.origin.R
import com.ytplus.manager.origin.utils.*
import com.ytplus.manager.origin.utils.DownloadHelper.download
import com.ytplus.manager.origin.utils.PackageHelper.install

object MicrogDownloader {

    private const val fileName = "microg.apk"
    private const val folderName = "microg"

    fun downloadMicrog(context: Context) {
        val url = microg.value?.string("url") ?: ""
        download(url, "$baseInstallUrl/", folderName, fileName, context, onDownloadComplete = {
            startMicrogInstall(context)
        }, onError = {
            downloadingFile.postValue(context.getString(R.string.error_downloading, fileName))
        })

    }

    fun startMicrogInstall(context: Context) {
        installing.postValue(true)
        postReset()
        install("${context.getExternalFilesDir(folderName)}/$fileName", context)
    }
}
