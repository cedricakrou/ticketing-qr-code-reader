package com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewIntent

sealed class HomeIntent : IViewIntent {
    object INIT : HomeIntent()
}