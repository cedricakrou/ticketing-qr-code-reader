package com.cedricakrou.ticketingqrcoderearder.data.managers.contrats

import com.cedricakrou.ticketingqrcoderearder.data.common.ApiResponse
import com.cedricakrou.ticketingqrcoderearder.data.common.Result
import kotlinx.coroutines.flow.Flow

interface QrCodeManager {

    fun scanQrCode( ticketNumber : Long ) : Flow<Result<ApiResponse<Nothing>>>

}