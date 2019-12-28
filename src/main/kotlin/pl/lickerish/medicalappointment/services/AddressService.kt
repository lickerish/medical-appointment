package pl.lickerish.medicalappointment.services

import org.springframework.stereotype.Service
import pl.lickerish.medicalappointment.dto.AddressDTO
import pl.lickerish.medicalappointment.exceptions.AddressNotFoundException
import pl.lickerish.medicalappointment.models.Address
import pl.lickerish.medicalappointment.repositories.AddressRepository
import java.util.*

@Service
class AddressService(val addressRepository: AddressRepository) {

    fun create(address: AddressDTO): Address = this.addressRepository.save(Address(null, address.street, address.houseNumber, address.city, address.country, address.postalCode))

    fun findAll(): List<Address> = this.addressRepository.findAll()

    fun findById(id: Long): Optional<Address> = this.addressRepository.findById(id)

    fun update(address: AddressDTO, id: Long): Address {
        return this.addressRepository.findById(id).map {
            val updatedAddress = it.copy(
                    street = address.street,
                    houseNumber = address.houseNumber,
                    city = address.city,
                    country = address.country,
                    postalCode = address.postalCode)
            addressRepository.save(updatedAddress)
        }.orElseThrow { throw AddressNotFoundException("Address not found. Nothing to update") }
    }

    fun delete(id: Long) = this.addressRepository.deleteById(id)
}