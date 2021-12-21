package com.cedricakrou.ticketingqrcoderearder.presentation.features.splash.ui

import android.content.Intent
import android.view.animation.AnimationUtils
import com.cedricakrou.ticketingqrcoderearder.presentation.common.BaseActivity
import com.cedricakrou.ticketingqrcoderearder.presentation.features.onboarding.ui.OnboardingActivity
import com.cedricakrou.ticketingqrcoderearder.presentation.features.home.ui.HomeActivity
import com.cedricakrou.ticketingqrcoderearder.presentation.features.splash.SplashAction
import com.cedricakrou.ticketingqrcoderearder.presentation.features.splash.SplashIntent
import com.cedricakrou.ticketingqrcoderearder.presentation.features.splash.SplashState
import com.cedricakrou.ticketingqrcoderearder.presentation.features.splash.SplashViewModel
import com.cedricakrou.ticketingqrcoderearder.R
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.sleep

class SplashActivity : BaseActivity<
        SplashIntent, SplashAction, SplashState, SplashViewModel>( SplashViewModel::class.java )
{
    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initUI() {

        val animation = AnimationUtils.loadAnimation(this, R.anim.anim)
        img_logo.startAnimation(animation)



    }

    override fun initDATA() {

        Thread {

            sleep(2000)

            dispatchIntent( SplashIntent.Init )

        }.start()

    }

    override fun initEVENT() {


    }

    override fun render(state: SplashState) {
        when( state ) {
            SplashState.FirstConnection -> {
                val intent = Intent(this, OnboardingActivity::class.java)
                startActivity(intent)
                finish()
            }

            SplashState.SignUp -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

}