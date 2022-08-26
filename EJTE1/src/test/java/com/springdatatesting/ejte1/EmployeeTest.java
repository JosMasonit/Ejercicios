package com.springdatatesting.ejte1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeTest {

    @Test
    public void newEmployee(){
        Employee employee = new Employee(1L, "JoseM", "Manresa", "jomaser@gmail.com");

        Assertions.assertThat(employee.getId()).isEqualTo(1);

        Assertions.assertThat(employee.getFirstName()).isEqualTo("JoseM");

        Assertions.assertThat(employee.getLastName()).isEqualTo("Manresa");

        Assertions.assertThat(employee.getEmail()).isEqualTo("jomaser@gmail.com");
    }
}
