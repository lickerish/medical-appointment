package pl.lickerish.medicalappointment.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.lickerish.medicalappointment.models.Address

@Repository
interface AddressRepository : JpaRepository<Address, Long>