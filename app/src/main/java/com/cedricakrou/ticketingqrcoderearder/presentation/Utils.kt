package com.cedricakrou.ticketingqrcoderearder.presentation

import android.view.View

object Utils {

    fun hideAndShowView( hide : View, show : View ) {
        hide.visibility = View.GONE
        show.visibility = View.VISIBLE
    }

}