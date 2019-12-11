package pl.lickerish.medicalappointment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MedicalAppointmentApplication

fun main(args: Array<String>) {
	runApplication<MedicalAppointmentApplication>(*args)
}
