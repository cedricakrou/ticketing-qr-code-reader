package com.cedricakrou.ticketingqrcoderearder.data.common

data class ApiResponse<T : Any>(var message : String = "", var error : Boolean = true, var data : T? = null )