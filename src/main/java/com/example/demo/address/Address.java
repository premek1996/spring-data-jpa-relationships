package com.example.demo.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "address")
@Entity(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "street",
            nullable = false
    )
    private String street;

    @Column(
            name = "house_number",
            nullable = false
    )
    private String houseNumber;

    @Column(
            name = "zip_code",
            nullable = false
    )
    private String zipCode;

}
