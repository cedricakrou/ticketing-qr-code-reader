package com.cedricakrou.ticketingqrcoderearder.presentation.common

import android.os.Bundle
import androidx.annotation.LayoutRes

/**
 * Cette classe permet d'associer les activités, les view models ainsi que les intents, actions et les divers états
 */

abstract class BaseActivity<
        INTENT : IViewIntent,
        ACTION : IViewAction,
        STATE : IViewState,
        VM : BaseViewModel<INTENT, ACTION, STATE>> (private val modelClass: Class<VM>)
    : RootBaseActivity(), IViewRenderer<STATE>
{

    private lateinit var viewState : STATE
    val mState get() = viewState

    private val viewModel : VM by lazy {
        viewModelProvider(
            this.viewModelFactory,
            modelClass.kotlin
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView( getLayoutResId() )
        initUI()


        viewModel.state.observe( this , {
            viewState = it
            render( it )
        })

        initDATA()
        initEVENT()

    }

    @LayoutRes
    abstract fun getLayoutResId() : Int
    abstract fun initUI()
    abstract fun initDATA()
    abstract fun initEVENT()

    fun dispatchIntent( intent : INTENT ) {
        viewModel.dispatchIntent(intent)
    }

}