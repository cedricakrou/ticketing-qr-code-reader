package com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui

import com.cedricakrou.ticketingqrcoderearder.presentation.common.BaseViewModel
import com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui.HomeAction
import com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui.HomeIntent
import com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui.HomeState
import javax.inject.Inject


class HomeViewModel @Inject constructor(
) : BaseViewModel<
        HomeIntent,
        HomeAction,
        HomeState>()
{
    override fun intentToAction(intent: HomeIntent): HomeAction {

        return when( intent ) {
            is HomeIntent.INIT -> HomeAction.INIT
        }

    }

    override fun handleAction(action: HomeAction) {

        launchOnUi {

            when( action ) {

                is HomeAction.INIT -> {

                }

            }

        }

    }
}