package com.example.demo.employee.model;

import com.example.demo.address.Address;
import com.example.demo.department.model.Department;
import com.example.demo.misson.Mission;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "missions")
@Table(name = "employee")
@Entity(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "birth_date",
            nullable = false
    )
    private LocalDate birthDate;

    @Enumerated(value = EnumType.STRING)
    @Column(
            name = "employee_role",
            nullable = false
    )
    private EmployeeRole employeeRole;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "address_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "employee_address_id_fk"
            )
    )
    private Address address;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "employee_department_id"
            )
    )
    private Department department;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "employee_mission",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")

    )
    @Singular
    private Set<Mission> missions;

}
