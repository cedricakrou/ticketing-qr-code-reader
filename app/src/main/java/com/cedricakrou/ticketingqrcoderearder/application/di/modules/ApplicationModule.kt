package com.cedricakrou.ticketingqrcoderearder.application.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.cedricakrou.ticketingqrcoderearder.ApplicationStartup
import com.cedricakrou.ticketingqrcoderearder.data.managers.contrats.QrCodeManager
import com.cedricakrou.ticketingqrcoderearder.data.managers.remote.impl.QrCodeManagerImpl
import com.cedricakrou.ticketingqrcoderearder.infrastructure.remote.ApiService
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideApplicationContext( application : ApplicationStartup) : Context = application.applicationContext


    @Provides
    fun sharedPreferences( context: Context ) : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun providesSharedPreferencesEditor( sharedPreferences: SharedPreferences ) : SharedPreferences.Editor = sharedPreferences.edit()


    @Provides
    fun providesQrCodeAccessor( apiService: ApiService) : QrCodeManager = QrCodeManagerImpl( apiService )

}