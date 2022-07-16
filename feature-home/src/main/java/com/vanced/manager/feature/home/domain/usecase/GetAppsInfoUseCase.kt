package com.ytplus.manager.origin.feature.home.domain.usecase

import com.ytplus.manager.origin.feature.home.domain.entity.AppInfo
import com.ytplus.manager.origin.feature.home.domain.repository.AppsRepository

class GetAppsInfoUseCase(
    private val repository: AppsRepository
) {

    suspend operator fun invoke(): List<AppInfo> =
        repository.getAppsInfo()
}