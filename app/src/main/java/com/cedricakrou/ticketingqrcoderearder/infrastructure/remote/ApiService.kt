package com.cedricakrou.ticketingqrcoderearder.infrastructure.remote

import com.cedricakrou.ticketingqrcoderearder.data.common.ApiResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST( value =  Config.scan )
    suspend fun scanQrCode(@Field( value = "ticketNumber" ) ticketNumber : Long ) : Response<ApiResponse<Nothing>>

}