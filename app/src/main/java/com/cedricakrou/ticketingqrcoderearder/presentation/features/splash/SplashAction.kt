package com.cedricakrou.ticketingqrcoderearder.presentation.features.splash

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewAction

sealed class SplashAction : IViewAction {
    object Init : SplashAction()
}