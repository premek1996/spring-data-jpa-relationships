package com.example.demo.misson;

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
@Table(name = "mission")
@Entity(name = "Mission")
public class Mission {

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

    @Column(
            name = "period",
            nullable = false
    )
    private Integer period;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy = "missions"
    )
    @Builder.Default
    private Set<Employee> employees = new HashSet<>();

}
