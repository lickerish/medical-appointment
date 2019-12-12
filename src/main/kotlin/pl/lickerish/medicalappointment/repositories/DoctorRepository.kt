package pl.lickerish.medicalappointment.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.lickerish.medicalappointment.models.Doctor
@Repository
interface DoctorRepository : JpaRepository<Doctor, Long> {
}