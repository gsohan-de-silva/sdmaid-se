package eu.darken.sdmse.common.clutter.dynamic.modules

import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import eu.darken.sdmse.common.clutter.MarkerSource
import eu.darken.sdmse.common.clutter.dynamic.NestedPackageMatcher
import eu.darken.sdmse.common.storageareas.StorageArea
import javax.inject.Inject

@Reusable
class TencentTbsBackupDynamicMarker @Inject constructor() : NestedPackageMatcher(
    StorageArea.Type.SDCARD,
    "tencent/tbs/backup",
    setOf(".nomedia")
) {
    override fun toString(): String = "TencentTbsBackupDynamicMarker"

    @Module @InstallIn(SingletonComponent::class)
    abstract class DIM {
        @Binds @IntoSet abstract fun source(source: TencentTbsBackupDynamicMarker): MarkerSource
    }
}