package com.cedricakrou.ticketingqrcoderearder.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties( ignoreUnknown = true )
class QrCode( val ticketNumber : String = "", val createdDate : String = "", val scanDate : String = "" ) {
}