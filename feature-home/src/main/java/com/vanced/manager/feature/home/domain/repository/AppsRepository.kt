package com.ytplus.manager.origin.feature.home.domain.repository

import com.ytplus.manager.origin.feature.home.domain.entity.AppInfo

interface AppsRepository {

    suspend fun getAppsInfo(): List<AppInfo>
}