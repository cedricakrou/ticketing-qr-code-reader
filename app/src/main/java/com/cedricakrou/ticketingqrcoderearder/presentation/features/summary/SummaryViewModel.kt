package com.cedricakrou.ticketingqrcoderearder.presentation.features.summary

import com.cedricakrou.ticketingqrcoderearder.data.common.ApiResponse
import com.cedricakrou.ticketingqrcoderearder.data.common.Result
import com.cedricakrou.ticketingqrcoderearder.data.managers.contrats.QrCodeManager
import com.cedricakrou.ticketingqrcoderearder.presentation.common.BaseViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class SummaryViewModel @Inject constructor(
    val qrCodeManager: QrCodeManager
) : BaseViewModel<SummaryIntent, SummaryAction, SummaryState>() {

    override fun intentToAction(intent: SummaryIntent): SummaryAction {

        return when( intent ) {
            is SummaryIntent.ClickScan ->  SummaryAction.Scan( intent.ticketNumber )
        }

    }

    override fun handleAction(action: SummaryAction) {

        launchOnUi {


            when (action) {
                is SummaryAction.Scan -> {

                    qrCodeManager.scanQrCode( ticketNumber = action.ticketNumber ).collect {

                        mState.postValue(
                            when( it ) {
                                is Result.Error -> SummaryState.ErrorSendCode( it.exception )
                                is Result.Success -> SummaryState.SuccessSendCode( ApiResponse( error=  it.data.error, message =  it.data.message, data =  null  ) )
                                is Result.Loading -> SummaryState.Loading
                            }
                        )

                    }

                }

            }

        }
    }

}