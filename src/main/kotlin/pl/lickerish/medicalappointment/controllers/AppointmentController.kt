package pl.lickerish.medicalappointment.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.lickerish.medicalappointment.dto.AppointmentDto
import pl.lickerish.medicalappointment.models.Appointment
import pl.lickerish.medicalappointment.services.AppointmentService

@RestController
@RequestMapping("/appointments")
class AppointmentController(val appointmentService: AppointmentService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<Appointment> = this.appointmentService.findAll()

    @GetMapping("/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    fun getAppointmentsByPatient(@PathVariable patientId: Long): List<Appointment> {
        return this.appointmentService.findByPatientId(patientId)
    }

    @PostMapping
    fun insert(@RequestBody appointmentDto: AppointmentDto): Appointment = this.appointmentService.create(appointmentDto)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateTime(@PathVariable id: Long, @RequestBody appointment: Appointment): Appointment = this.appointmentService.updateAppointmentTime(appointment, id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.appointmentService.delete(id)
}

