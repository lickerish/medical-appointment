package pl.lickerish.medicalappointment.controllers

import org.springframework.web.bind.annotation.*
import pl.lickerish.medicalappointment.models.Appointment
import pl.lickerish.medicalappointment.services.AppointmentService
import java.util.*

@RestController
@RequestMapping("/appointments")
class AppointmentController(val appointmentService: AppointmentService) {

    @GetMapping
    fun getAll(): List<Appointment> = this.appointmentService.findAll()

    // Not needed in spec -> done for test purposes
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Optional<Appointment> = this.appointmentService.findById(id)

    @GetMapping("/{id}")
    fun getAppointmentsByPatient(@PathVariable id: Long): List<Appointment> {
        return this.appointmentService.findByPatientId(id)
    }

    // #ToClarify - umówienie wizyty - najpierw tworzysz pacjenta i doktora, a później ich id przekazujesz aby umówić wizytę
    // One post for all or 3 posts
    @PostMapping
    fun insert(appointment: Appointment): Appointment = this.appointmentService.create(appointment)

    @PutMapping("/{id}")
    fun updateTime(@PathVariable id: Long, appointment: Appointment): Appointment = this.appointmentService.updateAppointmentTime(appointment, id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.appointmentService.delete(id)
}

