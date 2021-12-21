package com.cedricakrou.ticketingqrcoderearder.presentation.features.summary

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewAction


sealed class SummaryAction : IViewAction {
    data class SendCode( val memberNo : String ) : SummaryAction()
}