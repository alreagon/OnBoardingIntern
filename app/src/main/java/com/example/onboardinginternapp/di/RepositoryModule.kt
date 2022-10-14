package com.example.onboardinginternapp.di

import com.example.onboardinginternapp.data.remote.repository.RemoteRepository
import org.koin.dsl.module

val repoModule = module {
    single {RemoteRepository(get(),get())}
}