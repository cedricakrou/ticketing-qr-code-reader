package com.cedricakrou.ticketingqrcoderearder.application.di.components

import com.cedricakrou.ticketingqrcoderearder.presentation.common.RootBaseActivity
import com.cedricakrou.ticketingqrcoderearder.application.di.modules.ActivityModule
import com.cedricakrou.ticketingqrcoderearder.application.di.annotations.ActivityScope
import com.cedricakrou.ticketingqrcoderearder.application.di.common.AppRouter
import dagger.Component

@ActivityScope
@Component( modules = [ActivityModule::class], dependencies = [ApplicationComponent::class] )
interface ActivityComponent {
    fun inject( baseActivity: RootBaseActivity)
    fun appRouter() : AppRouter
}