package com.kzdev.projetohero.model

import com.kzdev.projetohero.model.PowerStatus


data class SuperHero (
    val id:Int,
    val name:String,
    val slug : String,
    val powerStatus: PowerStatus
)

