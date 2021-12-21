package com.cedricakrou.ticketingqrcoderearder.presentation.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cedricakrou.ticketingqrcoderearder.data.common.CallErrors
import kotlin.reflect.KClass

fun <T: ViewModel> RootBaseActivity.viewModelProvider(
    factory : ViewModelProvider.Factory,
    model: KClass<T>
) : T = ViewModelProvider( this, factory ).get( model.java )


fun Boolean.runIfTrue( block : () -> Unit ) {
    if ( this ) {
        block()
    }
}


fun CallErrors.getMessage(context: Context ) : String{

    return when( this ) {
        is CallErrors.ErrorEmptyData -> "Empty Data"
        is CallErrors.ErrorServer -> "Server Error"
        is CallErrors.ErrorException -> "Error loading data"
    }

}