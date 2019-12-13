package pl.lickerish.medicalappointment.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.lickerish.medicalappointment.models.Doctor
import pl.lickerish.medicalappointment.services.DoctorService
import java.util.*

@RestController
@RequestMapping("/doctors")
class DoctorController(val doctorService: DoctorService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll() = this.doctorService.findAll()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(@PathVariable id: Long): Optional<Doctor> = this.doctorService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody doctor: Doctor): Doctor = this.doctorService.create(doctor)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable id: Long, @RequestBody doctor: Doctor): Doctor = this.doctorService.update(doctor, id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.doctorService.delete(id)
}