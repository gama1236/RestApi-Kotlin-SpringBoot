package com.aprendiendoKotlinConSPB.restapi.web

import com.aprendiendoKotlinConSPB.restapi.business.IPersonasBusiness
import com.aprendiendoKotlinConSPB.restapi.excepcions.NotFoundException
import com.aprendiendoKotlinConSPB.restapi.excepcions.busissnesExcepcion
import com.aprendiendoKotlinConSPB.restapi.model.persona
import com.aprendiendoKotlinConSPB.restapi.ultils.constantes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception


@RestController
@RequestMapping(constantes.URL_BASE_PERSONAS)
class PersonaRestControl {

    @Autowired
    val personasBusiness: IPersonasBusiness?=null

    @GetMapping()
    fun list():ResponseEntity<List<persona>>{
        return try {
            ResponseEntity(personasBusiness!!.List(),HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id")idPesona:Long):ResponseEntity<Any>{
        return  try {
            ResponseEntity(personasBusiness!!.load(idPesona), HttpStatus.OK)
        }catch (e:busissnesExcepcion){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody persona: persona): ResponseEntity<Any>{
        return try {
            personasBusiness!!.save(persona)
            val respondHeader = HttpHeaders()
            respondHeader.set("locataion", constantes.URL_BASE_PERSONAS+ "/"+persona.id)
            ResponseEntity(respondHeader,HttpStatus.CREATED)
        }catch (e:busissnesExcepcion){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody persona: persona): ResponseEntity<Any>{
        return try {
            personasBusiness!!.save(persona)
            ResponseEntity(HttpStatus.OK)
        }catch (e:busissnesExcepcion){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @DeleteMapping("/{id}")
    fun delect(@PathVariable(value = "id")idPesona: Long): ResponseEntity<Any>{
        return try {
            personasBusiness!!.remove(idPesona)
            ResponseEntity(HttpStatus.OK)
        }catch (e:busissnesExcepcion){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:NotFoundException ){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}