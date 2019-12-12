package pl.lickerish.medicalappointment.models

import javax.persistence.Id

data class Patient(@Id
                   val id: Long,
                   var firstName: String,
                   var lastName: String,
                   var address: String)