package com.cedricakrou.ticketingqrcoderearder.application.di.viewmodels

import androidx.lifecycle.ViewModel
import com.cedricakrou.ticketingqrcoderearder.application.di.annotations.ViewModelKey
import com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui.HomeViewModel
import com.cedricakrou.ticketingqrcoderearder.presentation.features.onboarding.OnBoardingViewModel
import com.cedricakrou.ticketingqrcoderearder.presentation.features.splash.SplashViewModel
import com.cedricakrou.ticketingqrcoderearder.presentation.features.summary.SummaryViewModel
import com.cedricakrou.ticketingqrcoderearder.presentation.features.summary.ui.SummaryActivity
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey( SplashViewModel::class )
    abstract fun bindSplashViewModel( vm : SplashViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( OnBoardingViewModel::class )
    abstract fun bindOnBoardingViewModel( vm : OnBoardingViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( HomeViewModel::class )
    abstract fun bindHomeViewModel( vm : HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( SummaryViewModel::class )
    abstract fun bindSummaryViewModel( vm : SummaryViewModel) : ViewModel
}