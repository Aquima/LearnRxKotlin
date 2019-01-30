package com.tcs

import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Tracks the score for Team A
    public var scoreTeamA:Int = 0
    private set
    // Tracks the score for Team B
    public var scoreTeamB:Int = 0
    private set

    fun sumarScoreA(value:Int){
        this.scoreTeamA += value
    }
    fun sumarScoreB(value:Int){
        this.scoreTeamB += value
    }
    fun resetScore(){
        this.scoreTeamA = 0
        this.scoreTeamB = 0
    }
}

