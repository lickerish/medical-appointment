package pl.lickerish.medicalappointment.services

import org.springframework.stereotype.Service
import pl.lickerish.medicalappointment.exceptions.AppointmentNotFoundException
import pl.lickerish.medicalappointment.models.Appointment
import pl.lickerish.medicalappointment.repositories.AppointmentRepository
import java.util.*

@Service
class AppointmentService(val appointmentRepository: AppointmentRepository) {
    fun findAll(): List<Appointment> = this.appointmentRepository.findAll()

    fun findById(id: Long): Optional<Appointment> = this.appointmentRepository.findById(id)

    fun findByPatientId(id: Long): List<Appointment> {
        return appointmentRepository.findAppointmentsByPatientId(id)
    }

    fun create(appointment: Appointment): Appointment = this.appointmentRepository.save(appointment)

    fun updateAppointmentTime(appointment: Appointment, id: Long): Appointment {
        return this.appointmentRepository.findById(id).map { existingAppointment ->
            val updatedAppointment = existingAppointment.copy(
                    time = appointment.time)
            appointmentRepository.save(updatedAppointment)
        }.orElseThrow { throw AppointmentNotFoundException("Appointment not found. Nothing to update") }
    }

    fun delete(id: Long) = this.appointmentRepository.deleteById(id)
}
