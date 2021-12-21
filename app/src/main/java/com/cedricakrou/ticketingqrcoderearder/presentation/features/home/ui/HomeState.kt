package com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewState

sealed class HomeState : IViewState {

    object LOADING : HomeState()

    object ScanSuccess : HomeState()
    data class ScanFailed( val error : String) : HomeState()

}