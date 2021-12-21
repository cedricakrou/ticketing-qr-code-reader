package com.cedricakrou.ticketingqrcoderearder.data.managers.remote.impl


import com.cedricakrou.ticketingqrcoderearder.data.common.ApiResponse
import com.cedricakrou.ticketingqrcoderearder.data.common.CallErrors
import com.cedricakrou.ticketingqrcoderearder.data.common.Result
import com.cedricakrou.ticketingqrcoderearder.data.common.applyCommonSideEffects
import com.cedricakrou.ticketingqrcoderearder.data.managers.contrats.QrCodeManager
import com.cedricakrou.ticketingqrcoderearder.infrastructure.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class QrCodeManagerImpl( private val apiService : ApiService) : QrCodeManager {

    override fun scanQrCode( ticketNumber: Long): Flow<Result<ApiResponse<Nothing>>> = flow {

        apiService.scanQrCode( ticketNumber = ticketNumber ).run {

            if ( this.isSuccessful ){

                if ( this.body()==null){
                    emit( Result.Error( CallErrors.ErrorEmptyData ) )
                }
                else {
                    emit( Result.Success(
                        ApiResponse(
                            error = this.body()!!.error,
                            message = this.body()!!.message,
//                            data = this.body()!!.data
                            data = null
                        )
                    )
                    )
                }

            }
            else {
                emit( Result.Error( CallErrors.ErrorServer ) )
            }

        }

    }.applyCommonSideEffects().catch {
        emit(Result.Error(CallErrors.ErrorException(it)))
    }


}