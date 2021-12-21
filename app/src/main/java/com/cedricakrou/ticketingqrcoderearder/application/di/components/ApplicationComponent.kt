package com.cedricakrou.ticketingqrcoderearder.application.di.components

import com.cedricakrou.ticketingqrcoderearder.ApplicationStartup
import com.cedricakrou.ticketingqrcoderearder.application.di.modules.ApplicationModule
import com.cedricakrou.ticketingqrcoderearder.application.di.modules.NetworkModule
import com.cedricakrou.ticketingqrcoderearder.application.di.viewmodels.DaggerViewModelFactory
import com.cedricakrou.ticketingqrcoderearder.application.di.viewmodels.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component( modules = [ApplicationModule::class, NetworkModule::class , ViewModelModule::class ] )
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(app: ApplicationStartup): Builder
    }

    fun provideDaggerViewModelFactory(): DaggerViewModelFactory

}