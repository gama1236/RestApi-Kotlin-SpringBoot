package com.aprendiendoKotlinConSPB.restapi.model

import javax.persistence.*


@Entity
@Table(name = "Lista")
data class persona(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        val nombreTarea : String ,
        val descripcion1: String,
        val descripcion2: String,
        val descripcion3: String) {

}
