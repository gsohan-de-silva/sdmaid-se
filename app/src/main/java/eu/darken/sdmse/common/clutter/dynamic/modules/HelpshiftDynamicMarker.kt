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
class HelpshiftDynamicMarker @Inject constructor() : NestedPackageMatcher(
    StorageArea.Type.SDCARD,
    ".backups",
    setOf(".nomedia")
) {
    override fun toString(): String = "HelpshiftDynamicMarker"

    @Module @InstallIn(SingletonComponent::class)
    abstract class DIM {
        @Binds @IntoSet abstract fun source(source: HelpshiftDynamicMarker): MarkerSource
    }
}