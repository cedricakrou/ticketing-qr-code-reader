package com.cedricakrou.ticketingqrcoderearder.presentation.features.summary.ui

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.cedricakrou.ticketingqrcoderearder.presentation.features.summary.SummaryAction
import com.cedricakrou.ticketingqrcoderearder.presentation.features.summary.SummaryIntent
import com.cedricakrou.ticketingqrcoderearder.presentation.features.summary.SummaryState
import com.cedricakrou.ticketingqrcoderearder.presentation.features.summary.SummaryViewModel
import com.cedricakrou.ticketingqrcoderearder.R
import com.cedricakrou.ticketingqrcoderearder.presentation.Utils
import com.cedricakrou.ticketingqrcoderearder.presentation.common.BaseActivity
import com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui.HomeActivity
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : BaseActivity<SummaryIntent, SummaryAction, SummaryState, SummaryViewModel>( SummaryViewModel::class.java)   {


    override fun getLayoutResId(): Int = R.layout.activity_summary

    override fun initUI() {

    }

    override fun initDATA() {

    }

    override fun initEVENT() {

        btn_scan.setOnClickListener {

//            dispatchIntent( SummaryIntent.ClickSendCode( memberNo = client.memberNo ) )

        }

    }

    override fun render(state: SummaryState) {

        when( state ) {
            is SummaryState.Loading ->  {

                Toast.makeText( this, "Envoi du code en cours", Toast.LENGTH_LONG ).show()

                Utils.hideAndShowView( loading_bar, ll_body)

            }
            is SummaryState.ErrorSendCode -> {

                Utils.hideAndShowView( loading_bar, ll_body)

                Toast.makeText( this, state.exception.toString(), Toast.LENGTH_SHORT ).show()
            }
            is SummaryState.SuccessSendCode -> {

                val response = state.response

                if ( response.error ) {
                    Toast.makeText( this, response.message, Toast.LENGTH_LONG ).show()
                }
                else {

                    createAlertDialog( this,
                    "Le client doit vous communiquer le code que vous utiliserez dans neo, en sus de son numéro d'assuré, pour verifier son identité."
                        )

                }


            }
        }

    }

    fun createAlertDialog(context: Context, message: String, success: Boolean = false) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle( "Code envoyé au Client" )
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->         // return home page

            val intent = Intent( this, HomeActivity::class.java )
            startActivity( intent )

            finish()

        }

        val drawable : Int = android.R.drawable.stat_notify_sync_noanim

        builder.setIcon(drawable)

        val dialog = builder.create()
        dialog.show()
    }

}