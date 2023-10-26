package com.example.store.utils.di

import com.example.store.data.models.login.BodyLogin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**Created by Arezou-Ghorbani on 26,October,2023,ArezouGhorbaniii@gmail.com**/
@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {
    @Provides
    fun bodyLogin() = BodyLogin()
}