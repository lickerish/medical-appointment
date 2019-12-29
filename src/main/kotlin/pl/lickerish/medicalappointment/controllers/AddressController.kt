package pl.lickerish.medicalappointment.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.lickerish.medicalappointment.dto.AddressDTO
import pl.lickerish.medicalappointment.models.Address
import pl.lickerish.medicalappointment.services.AddressService
import java.util.*

@RestController
@RequestMapping("/addresses")
class AddressController(val addressService: AddressService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody address: AddressDTO): Address = this.addressService.create(address)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll() = this.addressService.findAll()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(@PathVariable id: Long): Optional<Address> = this.addressService.findById(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable id: Long, @RequestBody address: AddressDTO): Address = this.addressService.update(address, id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = this.addressService.delete(id)
}