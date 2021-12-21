package com.cedricakrou.ticketingqrcoderearder.presentation.features.onboarding

import android.content.SharedPreferences
import com.cedricakrou.ticketingqrcoderearder.presentation.common.BaseViewModel
import com.cedricakrou.ticketingqrcoderearder.presentation.features.common.SharedPrefVar
import com.cedricakrou.ticketingqrcoderearder.presentation.features.onboarding.OnboardingAction
import com.cedricakrou.ticketingqrcoderearder.presentation.features.onboarding.OnboardingIntent
import com.cedricakrou.ticketingqrcoderearder.presentation.features.onboarding.OnboardingState
import javax.inject.Inject

class OnBoardingViewModel @Inject constructor(
    val editor: SharedPreferences.Editor
) : BaseViewModel<OnboardingIntent, OnboardingAction, OnboardingState>() {

    override fun intentToAction(intent: OnboardingIntent): OnboardingAction {
       return when( intent ) {
           is OnboardingIntent.FirstConnection -> OnboardingAction.FirstConnection
       }
    }

    override fun handleAction(action: OnboardingAction) {
        launchOnUi {
            when( action) {
                is OnboardingAction.FirstConnection -> {

                    editor.putBoolean( SharedPrefVar.firstConnection, true )
                    editor.apply()

                    mState.postValue(
                        OnboardingState.FirstConnection
                    )

                }
            }
        }
    }
}