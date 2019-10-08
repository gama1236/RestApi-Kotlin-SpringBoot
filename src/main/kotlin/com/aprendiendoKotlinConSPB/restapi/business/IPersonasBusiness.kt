package com.aprendiendoKotlinConSPB.restapi.business

import com.aprendiendoKotlinConSPB.restapi.model.persona

interface IPersonasBusiness {
    fun List(): List<persona>
    fun load(idPersona:Long):persona
    fun save(persona: persona):persona
    fun remove(idPersona: Long):persona
}