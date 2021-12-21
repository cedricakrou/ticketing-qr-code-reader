package com.cedricakrou.ticketingqrcoderearder.presentation.widget

import android.app.AlertDialog
import android.content.Context

class LikpechAlertDialog( private val context: Context,
                          private val title : String,
                          private val message : String,
                          private val drawable : Int = android.R.drawable.ic_dialog_alert,
                          private val function : () -> Unit  ) {

    init {

        val builder = AlertDialog.Builder(context)
        builder.setTitle( title )
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->         // return home page

            function()

        }


        builder.setIcon(drawable)

        val dialog = builder.create()
        dialog.show()

    }

}