package minori.eden.sion.mybook

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/**
 * @author Sion
 * @date 2023/9/5 11:43
 * @description
 * @version 1.0.0
 **/
@HiltAndroidApp
class MyBookApp : Application(){

    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }


}