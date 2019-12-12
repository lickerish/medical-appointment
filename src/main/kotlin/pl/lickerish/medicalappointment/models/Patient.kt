package pl.lickerish.medicalappointment.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "patient")
data class Patient(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   @Column(name = "id", updatable = false, nullable = false)
                   val id: Long?,
                   val firstName: String,
                   val lastName: String,
                   val address: String,
                   @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL] )
                   @JoinColumn(name = "PATIENT_ID")
                   var appointments: Set<Appointment>? = null) {


}
