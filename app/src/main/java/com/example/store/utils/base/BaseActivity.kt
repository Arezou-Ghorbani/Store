package com.example.store.utils.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper

/**Created by Arezou-Ghorbani on 19,October,2023,ArezouGhorbaniii@gmail.com**/
open class BaseActivity : AppCompatActivity() {
    //Calligraphy
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}