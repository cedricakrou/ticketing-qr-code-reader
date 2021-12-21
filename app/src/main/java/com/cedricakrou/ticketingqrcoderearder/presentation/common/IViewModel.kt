package com.cedricakrou.ticketingqrcoderearder.presentation.common

import androidx.lifecycle.LiveData

interface IViewModel<STATE : IViewState, INTENT : IViewIntent> {

    val state : LiveData<STATE>

    fun dispatchIntent( intent : INTENT)
}