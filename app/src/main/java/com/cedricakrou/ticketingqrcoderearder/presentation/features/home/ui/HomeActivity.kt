package com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cedricakrou.ticketingqrcoderearder.presentation.common.BaseActivity
import com.cedricakrou.ticketingqrcoderearder.R
import com.cedricakrou.ticketingqrcoderearder.domain.entities.QrCode
import com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui.reader.ZXingAutofocusScannerView
import com.cedricakrou.ticketingqrcoderearder.presentation.widget.LikpechAlertDialog
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class HomeActivity : BaseActivity<
        HomeIntent,
        HomeAction,
        HomeState,
        HomeViewModel>( HomeViewModel::class.java ) , ZXingScannerView.ResultHandler {

    private val REQUEST_CAMERA = 1

    private var mScannerView: ZXingAutofocusScannerView? = null

    override fun getLayoutResId(): Int = R.layout.activity_home

    override fun initUI() {
    }

    override fun initDATA() {

    }

    override fun initEVENT() {

    }

    override fun render(state: HomeState) {

        when( state ) {
            is HomeState.ScanSuccess -> Toast.makeText( this, "Succès", Toast.LENGTH_SHORT ).show()
        }

    }


    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            applicationContext,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            REQUEST_CAMERA
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            REQUEST_CAMERA -> if (grantResults.size > 0) {
                val cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED
                if (cameraAccepted) {
//                        Toast.makeText(getApplicationContext(), "Permission Granted, Now you can access camera", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(
                        applicationContext,
                        resources.getString(R.string.permissionCameraText),
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
            99 -> {


                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.tryAgainPrintTicket),
                        Toast.LENGTH_LONG
                    ).show()

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(
                        this,
                        resources.getString(R.string.permissonNotDenied),
                        Toast.LENGTH_LONG
                    ).show()
                }
                return
            }
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        mScannerView = ZXingAutofocusScannerView(this)
        setContentView(mScannerView)

        val currentApiVersion = Build.VERSION.SDK_INT

        if (currentApiVersion >= Build.VERSION_CODES.M) {
            if (checkPermission()) {
                //               Toast.makeText(getApplicationContext(), "Permission already granted!", Toast.LENGTH_LONG).show();
            } else {
                requestPermission()
            }
        }
    }


    override fun onResume() {
        super.onResume()
        mScannerView!!.setResultHandler(this)
        mScannerView!!.startCamera()
    }

    override fun onPause() {
        super.onPause()
        mScannerView!!.stopCamera()
    }

    override fun handleResult(p0: Result?) {

        try {

            val objectMapper : ObjectMapper = ObjectMapper()
            val data : QrCode  = objectMapper.readValue( p0!!.text, QrCode::class.java )

/**
            val intent : Intent = Intent( this, SummaryActivity::class.java )
            intent.putExtra( "data", data )
            startActivity(  intent )
**/
        }
        catch ( ex : Exception ) {

            LikpechAlertDialog(
                context = this,
                title = "Scan error",
                message = "Veuilllez réesayer plus tard, erreur lors du scan du Qr Code",
                function = {

                    mScannerView!!.resumeCameraPreview( this)

                }
            )

        }

    }


}