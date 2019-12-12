package pl.lickerish.medicalappointment.models

import javax.persistence.Id

data class Patient(@Id
                   val id: Long,
                   val firstName: String,
                   val lastName: String,
                   val address: String) {

}