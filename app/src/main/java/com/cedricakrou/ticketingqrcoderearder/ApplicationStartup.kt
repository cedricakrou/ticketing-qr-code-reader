package com.cedricakrou.ticketingqrcoderearder

import android.app.Application
import com.cedricakrou.ticketingqrcoderearder.application.di.components.ApplicationComponent
import com.cedricakrou.ticketingqrcoderearder.application.di.components.DaggerApplicationComponent

class ApplicationStartup : Application() {

    companion object {
        lateinit var appComponents : ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDI()
    }


    private fun initDI() : ApplicationComponent =  DaggerApplicationComponent.builder().application( this ).build()



}