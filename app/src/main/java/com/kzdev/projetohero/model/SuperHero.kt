package com.kzdev.projetohero.model


data class SuperHero (
    val id:Int,
    val name:String,
    val slug : String,
    val powerStatus: PowerStatus,
    val appearance: Appearance,
    val biography: Biography,
    val images: Images,

    )

