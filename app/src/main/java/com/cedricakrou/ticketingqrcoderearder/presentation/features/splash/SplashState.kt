package com.cedricakrou.ticketingqrcoderearder.presentation.features.splash

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewState

sealed class SplashState : IViewState {
    object FirstConnection : SplashState()
    object SignUp : SplashState()
}