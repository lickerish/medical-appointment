package pl.lickerish.medicalappointment.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.lickerish.medicalappointment.dto.PatientDTO
import pl.lickerish.medicalappointment.models.Patient
import pl.lickerish.medicalappointment.services.PatientService
import java.util.*

@RestController
@RequestMapping("/patients")
class PatientController(val patientService: PatientService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll() = this.patientService.findAll()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(@PathVariable id: Long): Optional<Patient> = this.patientService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody patient: PatientDTO): Patient = this.patientService.create(patient)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable id: Long, @RequestBody patient: PatientDTO): Patient = this.patientService.update(patient, id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.patientService.delete(id)
}