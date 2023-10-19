package com.example.store.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

/**Created by Arezou-Ghorbani on 19,October,2023,ArezouGhorbaniii@gmail.com**/
@HiltAndroidApp
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //Calligraphy
        ViewPump.init(
            ViewPump.builder().addInterceptor(
                CalligraphyInterceptor(
                    CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/iransans.ttf")
                        .build()
                )
            ).build()
        )
    }
}