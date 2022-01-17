package com.sirdave.marvelcomicsapp.ui

import android.app.Application
import com.sirdave.marvelcomicsapp.db.AppDatabase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class BaseApplication: Application()