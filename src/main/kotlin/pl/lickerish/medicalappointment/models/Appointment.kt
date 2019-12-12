package pl.lickerish.medicalappointment.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "appointment")
data class Appointment(@Id
                       @GeneratedValue(strategy = GenerationType.IDENTITY)
                       @Column(name = "id", updatable = false, nullable = false)
                       val id: Long?,
                       @JsonFormat(pattern = "dd::MM::yyyy")
                       val date: LocalDate? = null,
                       @JsonFormat(pattern = "KK:mm a")
                       val time: LocalTime? = null,
                       val place: String,
                       @ManyToOne
                       val doctor: Doctor? = null,
                       @ManyToOne
                       val patient: Patient? = null) {

}