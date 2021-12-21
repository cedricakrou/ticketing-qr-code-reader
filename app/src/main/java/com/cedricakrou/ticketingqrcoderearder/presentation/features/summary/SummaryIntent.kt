package com.cedricakrou.ticketingqrcoderearder.presentation.features.summary

import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewIntent


sealed class SummaryIntent : IViewIntent {

    data class ClickScan( val ticketNumber : Long ) : SummaryIntent()
}