package com.aprendiendoKotlinConSPB.restapi.business

import com.aprendiendoKotlinConSPB.restapi.dao.PersonaRepositorio
import com.aprendiendoKotlinConSPB.restapi.excepcions.NotFoundException
import com.aprendiendoKotlinConSPB.restapi.excepcions.busissnesExcepcion
import com.aprendiendoKotlinConSPB.restapi.model.persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaBusiness : IPersonasBusiness {

    @Autowired
    val personaRespository: PersonaRepositorio? = null

    @Throws(busissnesExcepcion::class)
    override fun List(): List<persona> {
        try {
            return personaRespository!!.findAll()
        } catch (e: Exception) {
            throw busissnesExcepcion(e.message)
        }
    }

    @Throws(busissnesExcepcion::class, NotFoundException::class)
    override fun load(idPersona: Long): persona {
        val op: Optional<persona>
        try {
            op = personaRespository!!.findById(idPersona)
        } catch (e: Exception) {
            throw  busissnesExcepcion(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("no se encontro la persona con el id $idPersona")
        }
        return op.get()
    }

    @Throws(busissnesExcepcion::class)
    override fun save(persona: persona): persona {
        try {
            return personaRespository!!.save(persona)
        } catch (e: Exception) {
            throw busissnesExcepcion(e.message)
        }
    }


    override fun remove(idPersona: Long): persona {
        val op: Optional<persona>
        try {
            op = personaRespository!!.findById(idPersona)

        } catch (e: Exception) {
            throw  busissnesExcepcion(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro la persona con el id $idPersona")
        } else {

            try {
                  personaRespository!!.deleteById(idPersona)
            } catch (e: Exception) {
                throw busissnesExcepcion(e.message)
            }
        }
     return op.get()

    }
}