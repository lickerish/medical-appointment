package pl.lickerish.medicalappointment.dto

import javax.validation.constraints.Pattern

data class AddressDTO(
        val street: String,
        val houseNumber: String,
        val city: String,
        val country: String,
        @Pattern(regexp = "\\d{2}(-\\d{3})?", message = "Invalid zip code! Format: **-***")
        val postalCode: String)