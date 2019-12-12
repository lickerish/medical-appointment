package pl.lickerish.medicalappointment.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.lickerish.medicalappointment.models.Appointment
@Repository
interface AppointmentRepository : JpaRepository<Appointment, Long> {
}