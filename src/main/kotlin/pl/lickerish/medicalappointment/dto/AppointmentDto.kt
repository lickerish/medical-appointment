package pl.lickerish.medicalappointment.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.LocalTime

data class AppointmentDto(
        @JsonFormat(pattern = "dd::MM::yyyy")
        val date: LocalDate,
        @JsonFormat(pattern = "KK:mm a")
        val time: LocalTime,
        val place: String,
        val doctorId: Long,
        val patientId: Long)