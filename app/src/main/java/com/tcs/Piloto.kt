package com.tcs

class Piloto(name:String,sexo:SexType) {

    private val meName:String = name
    private val sex:SexType = sexo
    var nave:NaveType? = null
    fun pilotear(nave:NaveType){
        this.nave = nave
    }
}

enum class NaveType {
    MOTORCYCLE,AIRPLANE,CARR
}
enum class SexType{
    MALE,FEMALE
}