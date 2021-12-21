package com.cedricakrou.ticketingqrcoderearder.presentation.features.summary

import com.cedricakrou.ticketingqrcoderearder.presentation.common.BaseViewModel
import javax.inject.Inject

class SummaryViewModel @Inject constructor() : BaseViewModel<SummaryIntent, SummaryAction, SummaryState>() {

    override fun intentToAction(intent: SummaryIntent): SummaryAction {

        return when( intent ) {
            is SummaryIntent.ClickSendCode ->  SummaryAction.SendCode( intent.memberNo )
        }

    }

    override fun handleAction(action: SummaryAction) {

        launchOnUi {


            when (action) {
                is SummaryAction.SendCode -> {



                }

            }

        }
    }

}