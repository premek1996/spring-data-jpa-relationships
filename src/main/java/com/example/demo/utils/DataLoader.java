package com.example.demo.utils;

import com.example.demo.address.Address;
import com.example.demo.department.model.Department;
import com.example.demo.employee.model.Employee;
import com.example.demo.employee.model.EmployeeRole;
import com.example.demo.employee.repository.EmployeeRepository;
import com.example.demo.misson.Mission;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {

        loadRandomData();
    }

    private void loadRandomData() {
        var faker = new Faker();
        var addressFaker = faker.address();
        var nameFaker = faker.name();
        var internetFaker = faker.internet();

        var address = Address.builder()
                .houseNumber(addressFaker.streetAddressNumber())
                .street(addressFaker.streetName())
                .zipCode(addressFaker.zipCode())
                .build();

        var department = Department.builder()
                .name("Department IT")
                .build();

        var mission = Mission.builder()
                .name("Mission 1")
                .period(60)
                .build();

        var employee = Employee.builder()
                .firstName(nameFaker.firstName())
                .lastName(nameFaker.lastName())
                .email(internetFaker.emailAddress())
                .birthDate(LocalDate.now().minusYears(30))
                .employeeRole(EmployeeRole.DEVELOPER)
                .address(address)
                .department(department)
                .mission(mission)
                .build();

        employeeRepository.save(employee);
    }
}
