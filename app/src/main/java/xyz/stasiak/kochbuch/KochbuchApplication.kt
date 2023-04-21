package xyz.stasiak.kochbuch

import android.app.Application
import xyz.stasiak.kochbuch.data.AppContainer
import xyz.stasiak.kochbuch.data.AppDataContainer

class KochbuchApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
