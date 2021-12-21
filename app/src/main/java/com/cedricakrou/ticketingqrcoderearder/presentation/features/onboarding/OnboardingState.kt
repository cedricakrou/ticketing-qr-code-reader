package com.cedricakrou.ticketingqrcoderearder.presentation.features.onboarding

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewState

sealed class OnboardingState : IViewState {
    object FirstConnection : OnboardingState()
}