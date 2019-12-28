package pl.lickerish.medicalappointment.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.lickerish.medicalappointment.models.Patient

@Repository
interface PatientRepository : JpaRepository<Patient, Long>