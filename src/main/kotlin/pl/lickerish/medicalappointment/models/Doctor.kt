package pl.lickerish.medicalappointment.models

import javax.persistence.Id

data class Doctor(@Id
                  val id: Long,
                  val firstName: String,
                  val lastName: String,
                  val specialization: String) {
}
