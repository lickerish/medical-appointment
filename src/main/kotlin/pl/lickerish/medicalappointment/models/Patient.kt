package pl.lickerish.medicalappointment.models

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "patient")
data class Patient(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
        val id: Long?,
        val firstName: String,
        val lastName: String,
        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "addressId")
        @OnDelete(action = OnDeleteAction.CASCADE)
        val address: Address)
