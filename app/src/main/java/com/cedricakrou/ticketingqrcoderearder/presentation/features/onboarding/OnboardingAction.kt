package com.cedricakrou.ticketingqrcoderearder.presentation.features.onboarding

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewAction


sealed class OnboardingAction : IViewAction {
    object FirstConnection : OnboardingAction()
}