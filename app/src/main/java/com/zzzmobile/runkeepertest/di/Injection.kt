package com.zzzmobile.runkeepertest.di

import androidx.lifecycle.ViewModelProvider
import com.zzzmobile.runkeepertest.viewmodel.ViewModelFactory

object Injection {
    private val viewModelFactory = ViewModelFactory()

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return viewModelFactory
    }
}