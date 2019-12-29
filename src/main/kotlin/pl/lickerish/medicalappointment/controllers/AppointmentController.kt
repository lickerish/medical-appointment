package pl.lickerish.medicalappointment.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.lickerish.medicalappointment.dto.AppointmentDTO
import pl.lickerish.medicalappointment.models.Appointment
import pl.lickerish.medicalappointment.services.AppointmentService

@RestController
@RequestMapping("/appointments")
class AppointmentController(val appointmentService: AppointmentService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<Appointment> = this.appointmentService.findAll()

    @ResponseStatus(HttpStatus.OK)
    fun getAppointmentsByPatient(@RequestParam("patientId") patientId: Long): List<Appointment> {
        return this.appointmentService.findByPatientId(patientId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody appointmentDTO: AppointmentDTO): Appointment = this.appointmentService.create(appointmentDTO)

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateTime(@PathVariable id: Long, @RequestBody appointment: AppointmentDTO): Appointment = this.appointmentService.updateAppointmentTime(appointment, id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = this.appointmentService.delete(id)
}

