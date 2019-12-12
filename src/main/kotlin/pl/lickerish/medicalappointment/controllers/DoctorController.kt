package pl.lickerish.medicalappointment.controllers

import org.springframework.web.bind.annotation.*
import pl.lickerish.medicalappointment.models.Doctor
import pl.lickerish.medicalappointment.services.DoctorService
import java.util.*

@RestController
@RequestMapping("/doctors")
class DoctorController(val doctorService: DoctorService) {

    @GetMapping
    fun getAll() = this.doctorService.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Optional<Doctor> = this.doctorService.findById(id)

    @PostMapping
    fun insert(doctor: Doctor): Doctor = this.doctorService.create(doctor)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, doctor: Doctor): Doctor = this.doctorService.update(doctor, id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.doctorService.delete(id)
}