package com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui.reader

import android.content.Context
import android.hardware.Camera
import android.util.Log
import me.dm7.barcodescanner.core.CameraWrapper
import me.dm7.barcodescanner.zxing.ZXingScannerView
import java.lang.Exception

class ZXingAutofocusScannerView( context: Context ) : ZXingScannerView(context) {
    private val TAG = ZXingAutofocusScannerView::class.qualifiedName

    private var callbackFocus = false

    override fun setupCameraPreview(cameraWrapper: CameraWrapper?) {
        cameraWrapper?.mCamera?.parameters?.let{parameters->
            try {
                parameters.focusMode =
                    Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE
                cameraWrapper.mCamera.parameters = parameters
            }catch(ex:Exception){
                Log.e(TAG, "Failed to set CONTINOUS_PICTURE", ex)
                callbackFocus = true
            }
        }
        super.setupCameraPreview(cameraWrapper)
    }

    override fun setAutoFocus(state: Boolean) {
        super.setAutoFocus(callbackFocus)
    }
}