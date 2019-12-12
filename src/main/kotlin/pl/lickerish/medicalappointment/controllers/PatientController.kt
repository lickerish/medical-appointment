package pl.lickerish.medicalappointment.controllers

import org.springframework.web.bind.annotation.*
import pl.lickerish.medicalappointment.models.Patient
import pl.lickerish.medicalappointment.services.PatientService
import java.util.*

@RestController
@RequestMapping("/patients")
class PatientController(val patientService: PatientService) {

    @GetMapping
    fun getAll() = this.patientService.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Optional<Patient> = this.patientService.findById(id)

    @PostMapping
    fun insert(patient: Patient): Patient = this.patientService.create(patient)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, patient: Patient): Patient = this.patientService.update(patient, id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.patientService.delete(id)
}