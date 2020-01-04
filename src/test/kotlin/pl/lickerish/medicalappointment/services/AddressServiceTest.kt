package pl.lickerish.medicalappointment.services

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.lickerish.medicalappointment.dto.AddressDTO


@SpringBootTest
class AddressServiceTest() {

    @Autowired
    lateinit var addressService: AddressService
    val address: AddressDTO = AddressDTO("Street", "21", "Poznan", "Poland", "51-043")

    @Test
    fun `Should return empty optional after delete`() {
        addressService.create(address)
        addressService.delete(1)
        Assertions.assertTrue(addressService.findById(1).isEmpty)
    }

    @Test
    fun `List should be shorter by 1 after delete`() {
        addressService.create(address)
        val previousSize = addressService.findAll().size
        addressService.delete(1);
        val actualSize = addressService.findAll().size
        Assertions.assertTrue(previousSize > actualSize)
    }
}