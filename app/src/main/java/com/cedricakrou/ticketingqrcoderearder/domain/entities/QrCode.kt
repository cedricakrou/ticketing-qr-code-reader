package com.cedricakrou.ticketingqrcoderearder.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties( ignoreUnknown = true )
class QrCode( val ticketNumber : Long = -1L, val createdDate : String = "", val scanDate : String = "" ) : Serializable