package com.tcs

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val mVmainModel = MainViewModel()
        mVmainModel.sumarScoreA(3)
        assertEquals(3, mVmainModel.scoreTeamA)
        mVmainModel.resetScore()
        assertEquals(0, mVmainModel.scoreTeamA)
    }
}
