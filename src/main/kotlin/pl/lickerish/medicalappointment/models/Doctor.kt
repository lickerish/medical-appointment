package pl.lickerish.medicalappointment.models

data class Doctor(val id: Long,
                  val firstName: String,
                  val lastName: String,
                  val specialization: String) {
}
