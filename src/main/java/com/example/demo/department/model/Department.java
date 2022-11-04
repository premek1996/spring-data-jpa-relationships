package com.example.demo.department.model;

import com.example.demo.employee.model.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employees")
@Builder
@Table(name = "department")
@Entity(name = "Department")
public class Department {

    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @OneToMany(mappedBy = "department",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @Builder.Default
    private Set<Employee> employees = new HashSet<>();

}
