package com.cedricakrou.ticketingqrcoderearder.presentation.features.splash

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewIntent

sealed class SplashIntent : IViewIntent {
    object Init : SplashIntent()
}