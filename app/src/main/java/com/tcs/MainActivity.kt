package com.tcs

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import io.reactivex.Observable
import io.reactivex.Observer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timerTask

/*
    Array mutable y no mutable - val o var
    Crear contructores multiples
    Investigar el uso de Ambitos y cuantos existen private,public,protected
 */
class MainActivity : AppCompatActivity() {

    lateinit var mViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        displayForTeamA(mViewModel.scoreTeamA)
        displayForTeamB(mViewModel.scoreTeamB)
        observableExampleOne()
       // val homeViewModel = ViewModelProviders.of(this, this.viewModeFactory).get(MainViewModel::class.java)
    }

    fun observableExampleOne(){
        var listInt = mutableListOf<Int>(1,2,3,4)
        listInt.add(4)
        var listNOMuable = listOf<String>("A","B","C")

/*
        val observable:Observable<Int> = Observable.fromArray(
            1,2,3,4,5
        )
*/
        val valueOb:Int = 5
        val observable:Observable<Int> = Observable.create { observer ->
            val suma:Int = 1 + 4
            observer.onNext(suma)
            val resta:Int = 5 - 2
            observer.onNext(resta)
            val valueStr = "4"
            val resataString:Int = 7 - valueStr.toInt()
            observer.onNext(resataString)
            observer.onNext(valueOb)
            observer.onComplete()

        }

        val disposable = observable.subscribe({number:Int ->
            Log.v("VALUE",number.toString())
        } ,{error ->
            Log.v("VALUE",error.message)

        },{   Log.v("VALUE","Se Completo")},
            {Log.v("VALUE","is Susbcribed On")})
        disposable.dispose()
    }

    override fun onStop() {
        super.onStop()
    }
    /**
     * Increase the score for Team A by 1 points.
     */
    fun addOneForTeamA(view:View){
        mViewModel.sumarScoreA(1)
        displayForTeamA(mViewModel.scoreTeamA)
    }
    /**
     * Increase the score for Team A by 2 points.
     */
    fun addTwoForTeamA(view:View){
        mViewModel.sumarScoreA(2)
        displayForTeamA(mViewModel.scoreTeamA)
    }
    /**
     * Increase the score for Team A by 3 points.
     */
    fun addThreeForTeamA(view:View){
        mViewModel.sumarScoreA(3)
        displayForTeamA(mViewModel.scoreTeamA)
    }

    /**
     * Increase the score for Team B by 1 points.
     */
    fun addOneForTeamB(view:View){
        mViewModel.sumarScoreB(1)
        displayForTeamB(mViewModel.scoreTeamB)
    }
    /**
     * Increase the score for Team B by 2 points.
     */
    fun addTwoForTeamB(view:View){
        mViewModel.sumarScoreB(2)
        displayForTeamB(mViewModel.scoreTeamB)

    }
    /**
     * Increase the score for Team B by 3 points.
     */
    fun addThreeForTeamB(view:View){
        mViewModel.sumarScoreB(3)
        displayForTeamB(mViewModel.scoreTeamB)

    }

    /**
     * Resets the score for both teams back to 0.
     */
    fun resetScore(v: View) {
        mViewModel.resetScore()
        displayForTeamA(mViewModel.scoreTeamA)
        displayForTeamB(mViewModel.scoreTeamB)
    }

    /**
     * Displays the given score for Team A.
     */
    fun displayForTeamA(score: Int) {

        this.team_a_score.text = score.toString()
    }

    /**
     * Displays the given score for Team B.
     */
    fun displayForTeamB(score: Int) {

        this.team_b_score.text = score.toString()
    }
}
