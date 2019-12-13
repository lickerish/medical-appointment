package pl.lickerish.medicalappointment.models

import javax.persistence.*

@Entity
@Table(name = "patient")
data class Patient(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   @Column(name = "id", updatable = false, nullable = false)
                   val id: Long?,
                   val firstName: String,
                   val lastName: String,
                   val address: String)
