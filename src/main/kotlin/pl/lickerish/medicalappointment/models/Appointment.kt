package pl.lickerish.medicalappointment.models

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.Id

data class Appointment(@Id
                       val id: Long,
                       val date: LocalDate,
                       val time: LocalTime,
                       val place: String,
                       val doctor: Doctor,
                       val patient: Patient)