package com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewAction

sealed class HomeAction : IViewAction {
    object INIT : HomeAction()
}