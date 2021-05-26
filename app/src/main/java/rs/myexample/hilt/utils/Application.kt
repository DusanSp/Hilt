package rs.myexample.hilt.utils

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import rs.myexample.hilt.BR
import rs.myexample.hilt.BuildConfig
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class Application : Application() {

    @Inject
    lateinit var releaseTree: ReleaseTree

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        initViewModelId()
    }

    private fun initViewModelId() {
        ViewModelIdProvider.viewModelId = BR.vm
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(
            when (BuildConfig.DEBUG) {
                true -> releaseTree //Timber.DebugTree()
                false -> releaseTree
            }
        )
    }
}