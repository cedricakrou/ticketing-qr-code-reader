package com.cedricakrou.ticketingqrcoderearder.application.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.cedricakrou.ticketingqrcoderearder.application.di.common.AppRouter
import com.cedricakrou.ticketingqrcoderearder.data.managers.contrats.QrCodeManager
import com.cedricakrou.ticketingqrcoderearder.data.managers.remote.impl.QrCodeManagerImpl
import com.cedricakrou.ticketingqrcoderearder.infrastructure.remote.ApiService
import com.cedricakrou.ticketingqrcoderearder.presentation.common.RootBaseActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor( private val activity: RootBaseActivity) {

    @Provides
    fun providesActivityContext() : Context = activity.application

    @Provides
    fun providesActivity() : RootBaseActivity { return activity }

    @Provides
    fun providesRouterComponent() : AppRouter = AppRouter( activity )

    @Provides
    fun sharedPreferences( context: Context ) : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun providesSharedPreferencesEditor( sharedPreferences: SharedPreferences ) : SharedPreferences.Editor = sharedPreferences.edit()


    @Provides
    fun providesQrCodeAccessor( apiService: ApiService) : QrCodeManager = QrCodeManagerImpl( apiService )

}
