package com.alexm.chess960.interfaces

import com.alexm.chess960.PausePlayState
import com.alexm.chess960.RunningClock
import io.reactivex.Observable

/**
 * Created by alexm on 21/05/2018.
 */

interface ClockContract {
    interface IView {
        fun showCountdown(remaningTime: String, clockSel: RunningClock)
        fun enableButton1(enabled: Boolean)
        fun enableButton2(enabled: Boolean)
        fun enableHomeButton(enabled: Boolean)
        fun enableSetButton(enabled: Boolean)
        fun enableRestartButton(enabled: Boolean)
        fun setPausePlayState(state: PausePlayState)
        fun finishCountdown()
        fun restartButtons(initText1: String, initText2: String)
        fun createSettingsDialog()
    }

    interface IPresenter {
        fun startCountdown(clockSel: RunningClock)
        fun pauseClock1()
        fun pauseClock2()
        fun pausePlay()
        fun setCountdown(timeControl1: Int, timeControl2: Int, inc1: Int, inc2: Int)
        fun subscribe(view: ClockContract.IView)
        fun unSubscribe()
    }

    interface ILogic {
        fun tick1(): Observable<String>
        fun tick2(): Observable<String>
        fun addIncrement1(): Observable<String>
        fun addIncrement2(): Observable<String>
        fun setTimeControls(timeControl1: Int, timeControl2: Int, inc1: Int, inc2: Int)
    }
}