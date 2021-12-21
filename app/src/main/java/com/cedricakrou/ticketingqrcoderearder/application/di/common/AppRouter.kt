package com.cedricakrou.ticketingqrcoderearder.application.di.common

import com.cedricakrou.ticketingqrcoderearder.application.di.annotations.ActivityScope
import com.cedricakrou.ticketingqrcoderearder.presentation.common.RootBaseActivity
import javax.inject.Inject

@ActivityScope
class AppRouter @Inject constructor( private val activity: RootBaseActivity)