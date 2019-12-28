package pl.lickerish.medicalappointment.services

import org.springframework.stereotype.Service
import pl.lickerish.medicalappointment.dto.PatientDTO
import pl.lickerish.medicalappointment.exceptions.AddressNotFoundException
import pl.lickerish.medicalappointment.exceptions.PatientNotFoundException
import pl.lickerish.medicalappointment.models.Patient
import pl.lickerish.medicalappointment.repositories.AddressRepository
import pl.lickerish.medicalappointment.repositories.PatientRepository
import java.util.*

@Service
class PatientService(val patientRepository: PatientRepository,
                     val addressRepository: AddressRepository) {
    fun findAll(): List<Patient> = this.patientRepository.findAll()

    fun findById(id: Long): Optional<Patient> = this.patientRepository.findById(id)

    fun create(patient: PatientDTO): Patient {
        val address = addressRepository.findById(patient.addressId).orElseThrow { throw AddressNotFoundException("Address not found.") }
        return this.patientRepository.save(Patient(null, patient.firstName, patient.lastName, address))
    }

    fun update(patient: PatientDTO, id: Long): Patient {
        val address = addressRepository.findById(patient.addressId).orElseThrow { throw AddressNotFoundException("Address not found.") }
        return this.patientRepository.findById(id).map { existingPatient ->
            val updatedPatient = existingPatient.copy(
                    firstName = patient.firstName,
                    lastName = patient.lastName,
                    address = address)
            patientRepository.save(updatedPatient)
        }.orElseThrow { throw PatientNotFoundException("Patient not found. Nothing to update") }
    }

    fun delete(id: Long) = this.patientRepository.deleteById(id)

}