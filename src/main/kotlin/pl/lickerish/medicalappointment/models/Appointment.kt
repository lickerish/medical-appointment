package pl.lickerish.medicalappointment.models

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
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
                       val date: LocalDate,

                       @JsonFormat(pattern = "KK:mm a")
                       val time: LocalTime,
                       val place: String,

                       @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
                       @JoinColumn(name = "doctorId")
                       @OnDelete(action = OnDeleteAction.CASCADE)
                       val doctor: Doctor,

                       @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
                       @JoinColumn(name = "patientId")
                       @OnDelete(action = OnDeleteAction.CASCADE)
                       val patient: Patient)