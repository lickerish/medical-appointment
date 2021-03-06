package pl.lickerish.medicalappointment.models

import javax.persistence.*
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name = "address")
data class Address(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
        val id: Long?,
        val street: String,
        val houseNumber: String,
        val city: String,
        val country: String,
        @Pattern(regexp = "\\d{2}(-\\d{3})?", message = "Invalid zip code! Format: **-***")
        @Size(min = 6, max = 6, message = "Postal code should be 6 character long")
        val postalCode: String)