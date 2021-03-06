package pl.lickerish.medicalappointment.models

import javax.persistence.*

@Entity
@Table(name = "doctor")
data class Doctor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
        val id: Long?,
        val firstName: String,
        val lastName: String,
        val specialization: String)