package pl.lickerish.medicalappointment.services

import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service
import pl.lickerish.medicalappointment.dto.AppointmentDTO
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

    fun create(appointmentDTO: AppointmentDTO): Appointment {
        val doctor: Optional<Doctor> = doctorRepository.findById(appointmentDTO.doctorId)
        val patient: Optional<Patient> = patientRepository.findById(appointmentDTO.patientId)
        val appointment = Appointment(null, appointmentDTO.date, appointmentDTO.time, appointmentDTO.place, doctor.get(), patient.get())
        when (checkIfExistAlreadyIgnoringIdPath(appointment)) {
            true -> throw Exception("Appointment is already created.")
            false -> return this.appointmentRepository.save(appointment)
        }
    }

    fun updateAppointmentTime(appointment: AppointmentDTO, id: Long): Appointment {
        return this.appointmentRepository.findById(id).map {
            val updatedAppointment = it.copy(
                    time = appointment.time)
            appointmentRepository.save(updatedAppointment)
        }.orElseThrow { throw AppointmentNotFoundException("Appointment not found. Nothing to update") }
    }

    fun delete(id: Long) = this.appointmentRepository.deleteById(id)

    fun checkIfExistAlreadyIgnoringIdPath(appointment: Appointment): Boolean {
        val modelMatcher = ExampleMatcher.matching().withIgnorePaths("id")
        val example = Example.of(appointment, modelMatcher)
        return appointmentRepository.exists(example)
    }
}
