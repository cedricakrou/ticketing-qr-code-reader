package com.cedricakrou.ticketingqrcoderearder.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Cette classe represente la base des view models
 */

abstract class BaseViewModel<INTENT : IViewIntent, ACTION : IViewAction, STATE : IViewState> : ViewModel(),
    IViewModel<STATE, INTENT> {

    protected val mState = MutableLiveData<STATE>()

    override val state: LiveData<STATE>
        get() = mState


    fun launchOnUi( block : suspend CoroutineScope.() -> Unit ) = viewModelScope.launch { block() }

    final override fun dispatchIntent(intent: INTENT) = handleAction( intentToAction( intent ) )

    abstract fun intentToAction( intent: INTENT ) : ACTION

    abstract fun handleAction( action : ACTION )
}