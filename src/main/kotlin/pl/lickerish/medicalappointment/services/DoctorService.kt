package pl.lickerish.medicalappointment.services

import org.springframework.stereotype.Service
import pl.lickerish.medicalappointment.exceptions.DoctorNotFoundException
import pl.lickerish.medicalappointment.models.Doctor
import pl.lickerish.medicalappointment.repositories.DoctorRepository
import java.util.*

@Service
class DoctorService(val doctorRepository: DoctorRepository) {

    fun findAll(): List<Doctor> = this.doctorRepository.findAll()

    fun findById(id: Long): Optional<Doctor> = this.doctorRepository.findById(id)

    fun create(doctor: Doctor): Doctor = this.doctorRepository.save(doctor)

    fun update(doctor: Doctor, id: Long): Doctor {
        return this.doctorRepository.findById(id).map { existingDoctor ->
            val updatedDoctor = existingDoctor.copy(
                    firstName = doctor.firstName,
                    lastName = doctor.lastName,
                    specialization = doctor.specialization)
            doctorRepository.save(updatedDoctor)
        }.orElseThrow { throw DoctorNotFoundException("Doctor not found. Nothing to update") }
    }

    fun delete(id: Long) = this.doctorRepository.deleteById(id)

}