package com.aprendiendoKotlinConSPB.restapi.dao

import com.aprendiendoKotlinConSPB.restapi.model.persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepositorio:  JpaRepository<persona,Long>