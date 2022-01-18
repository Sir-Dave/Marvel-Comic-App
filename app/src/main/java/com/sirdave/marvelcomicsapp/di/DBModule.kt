package com.sirdave.marvelcomicsapp.di

import android.content.Context
import androidx.room.Room
import com.sirdave.marvelcomicsapp.db.AppDatabase
import com.sirdave.marvelcomicsapp.db.dao.FavouriteDao
import com.sirdave.marvelcomicsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
class DBModule {
    @Singleton
    @Provides
    fun provideFavouriteDao(db: AppDatabase): FavouriteDao {
        return db.favouriteDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            Constants.APP_DATABASE
        )
            .build()
    }
}