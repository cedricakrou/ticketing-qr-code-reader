package com.cedricakrou.ticketingqrcoderearder.presentation.features.summary

import com.cedricakrou.ticketingqrcoderearder.data.common.ApiResponse
import com.cedricakrou.ticketingqrcoderearder.data.common.CallErrors
import com.cedricakrou.ticketingqrcoderearder.presentation.common.IViewState

sealed class SummaryState : IViewState {
    data class ErrorSendCode(val exception: CallErrors) : SummaryState()
    data class SuccessSendCode( val response: ApiResponse<Nothing>) : SummaryState()
    object Loading : SummaryState()
}