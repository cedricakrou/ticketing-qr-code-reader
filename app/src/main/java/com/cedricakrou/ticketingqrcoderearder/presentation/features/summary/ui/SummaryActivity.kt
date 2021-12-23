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
import com.cedricakrou.ticketingqrcoderearder.domain.entities.QrCode
import com.cedricakrou.ticketingqrcoderearder.presentation.Utils
import com.cedricakrou.ticketingqrcoderearder.presentation.common.BaseActivity
import com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui.HomeActivity
import com.cedricakrou.ticketingqrcoderearder.presentation.widget.LikpechAlertDialog
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : BaseActivity<SummaryIntent, SummaryAction, SummaryState, SummaryViewModel>( SummaryViewModel::class.java)   {

    lateinit var qrCode: QrCode

    override fun getLayoutResId(): Int = R.layout.activity_summary

    override fun initUI() {

        qrCode = intent.getSerializableExtra( "data" ) as QrCode

        tv_ticketNumber.text = qrCode.ticketNumber.toString()
        tv_name.text = qrCode.createdDate
        tv_contact.text = qrCode.scanDate

    }

    override fun initDATA() {

    }

    override fun initEVENT() {

        btn_submit.setOnClickListener {

            dispatchIntent( SummaryIntent.ClickScan( ticketNumber = qrCode.ticketNumber ) )

        }

    }

    override fun render(state: SummaryState) {

        when( state ) {
            is SummaryState.Loading ->  {

                Toast.makeText( this, "Envoi du code en cours", Toast.LENGTH_LONG ).show()

                Utils.hideAndShowView( ll_body, loading_bar)

            }
            is SummaryState.ErrorSendCode -> {

                Utils.hideAndShowView( loading_bar, ll_body)

                Toast.makeText( this, state.exception.toString(), Toast.LENGTH_SHORT ).show()
            }
            is SummaryState.SuccessSendCode -> {

                Utils.hideAndShowView( loading_bar, ll_body)

                val response = state.response

                if ( response.error ) {
//                    Toast.makeText( this, response.message, Toast.LENGTH_LONG ).show()

                    LikpechAlertDialog(
                        context = this,
                        title = "Scan error - Alerte Fraude ",
                        message = response.message,
                        function = {

                            val intent = Intent( this, HomeActivity::class.java )
                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity( intent )

                            finish()

                        }
                    )

                }
                else {

                    createAlertDialog( this,
                            response.message
                        )

                }


            }
        }

    }

    fun createAlertDialog(context: Context, message: String, success: Boolean = false) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle( "Result scan Qr Code" )
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->         // return home page

            val intent = Intent( this, HomeActivity::class.java )
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity( intent )

            finish()

        }

        val drawable : Int = android.R.drawable.stat_notify_sync_noanim

        builder.setIcon(drawable)

        val dialog = builder.create()
        dialog.show()
    }

}