package pl.lickerish.medicalappointment.services

import org.springframework.stereotype.Service
import pl.lickerish.medicalappointment.dto.AppointmentDto
import pl.lickerish.medicalappointment.exceptions.AppointmentNotFoundException
import pl.lickerish.medicalappointment.models.Appointment
import pl.lickerish.medicalappointment.models.Doctor
import pl.lickerish.medicalappointment.models.Patient
import pl.lickerish.medicalappointment.repositories.AppointmentRepository
import pl.lickerish.medicalappointment.repositories.DoctorRepository
import pl.lickerish.medicalappointment.repositories.PatientRepository
import java.util.*

@Service
class AppointmentService(val appointmentRepository: AppointmentRepository,
                         val doctorRepository: DoctorRepository,
                         val patientRepository: PatientRepository) {
    fun findAll(): List<Appointment> = this.appointmentRepository.findAll()

    fun findByPatientId(id: Long): List<Appointment> {
        return appointmentRepository.findAppointmentsByPatientId(id)
    }

    fun create(appointmentDto: AppointmentDto): Appointment {
        var doctor: Optional<Doctor> = doctorRepository.findById(appointmentDto.doctorId)
        var patient: Optional<Patient> = patientRepository.findById(appointmentDto.patientId)
        val appointment = Appointment(null, appointmentDto.date, appointmentDto.time, appointmentDto.place, doctor.get(), patient.get())
        return this.appointmentRepository.save(appointment)
    }

    fun updateAppointmentTime(appointment: Appointment, id: Long): Appointment {
        return this.appointmentRepository.findById(id).map { existingAppointment ->
            val updatedAppointment = existingAppointment.copy(
                    time = appointment.time)
            appointmentRepository.save(updatedAppointment)
        }.orElseThrow { throw AppointmentNotFoundException("Appointment not found. Nothing to update") }
    }

    fun delete(id: Long) = this.appointmentRepository.deleteById(id)
}
