package com.cedricakrou.ticketingqrcoderearder.presentation.features.onboarding

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewIntent

sealed class OnboardingIntent : IViewIntent {
    object FirstConnection : OnboardingIntent()
}