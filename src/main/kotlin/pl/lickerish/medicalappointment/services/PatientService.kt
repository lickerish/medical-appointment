package pl.lickerish.medicalappointment.services

import org.springframework.stereotype.Service
import pl.lickerish.medicalappointment.exceptions.PatientNotFoundException
import pl.lickerish.medicalappointment.models.Patient
import pl.lickerish.medicalappointment.repositories.PatientRepository
import java.util.*

@Service
class PatientService(val patientRepository: PatientRepository) {
    fun findAll(): List<Patient> = this.patientRepository.findAll()

    fun findById(id: Long): Optional<Patient> = this.patientRepository.findById(id)

    fun create(patient: Patient): Patient = this.patientRepository.save(patient)

    fun update(patient: Patient, id: Long): Patient {
        return this.patientRepository.findById(id).map { existingPatient ->
            val updatedPatient = existingPatient.copy(
                    firstName = patient.firstName,
                    lastName = patient.lastName,
                    address = patient.address)
            patientRepository.save(updatedPatient)
        }.orElseThrow { throw PatientNotFoundException("Patient not found. Nothing to update") }
    }

    fun delete(id: Long) = this.patientRepository.deleteById(id)

}