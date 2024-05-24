package com.example.contactlist.di

import com.example.contactlist.data.api.RetrofitInstance
import com.example.contactlist.data.repository.CustomerRepository
import com.example.contactlist.ui.customerlist.CustomerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitInstance.api }
    single { CustomerRepository(get()) }
    viewModel { CustomerViewModel(get()) }
}
