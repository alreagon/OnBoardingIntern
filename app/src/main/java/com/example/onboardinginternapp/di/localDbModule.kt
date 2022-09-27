package com.example.onboardinginternapp.di

import android.content.Context
import androidx.room.Room
import com.example.onboardinginternapp.data.local.db.LocalDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

//val localDbModule = module {
//    single { provideDb(androidContext()) }
//    single { provideProductDao(get()) }
//    single { provideProductDaoImpl(get()) }
//}
//
//private fun provideDb(context: Context) : MyDatabase {
//    return Room.databaseBuilder(context, MyDatabase::class.java,"my_db")
//        .fallbackToDestructiveMigration()
//        .allowMainThreadQueries()
//        .build()
//}
//
//private fun provideProductDao(myDatabase: MyDatabase): LocalDao {
//    return myDatabase.localDao()
//}
//
//private fun provideProductDaoImpl(localDao: LocalDao): LocalDaoHelperImpl {
//    return LocalDaoHelperImpl(localDao)
//}