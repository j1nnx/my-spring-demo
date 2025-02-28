package pro.hw_sb.my_spring_demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.hw_sb.my_spring_demo.model.Employee;
import pro.hw_sb.my_spring_demo.service.api.EmployeeService;
import pro.hw_sb.my_spring_demo.service.impl.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private EmployeeService employeeService;

    @BeforeEach
    void setUp(){
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void addEmployees_success(){
        Employee employee = new Employee(1, "Dima Davidov", 25000, 1);
        employeeService.addEmployee(employee);
        assertEquals(employee, employeeService.findEmployee(1));
    }

    @Test
    void addEmployees_alreadyExists() {
        Employee employee = new Employee(2, "Alexander Vladimerov", 15000, 2);
        employeeService.addEmployee(employee);
        assertThrows(RuntimeException.class, () -> employeeService.addEmployee(employee));
    }

    @Test
    void removeEmployee_success() {
        Employee employee = new Employee(3, "Damir Andreev", 40000, 1);
        employeeService.addEmployee(employee);
        employeeService.removeEmployee(3);
        assertThrows(RuntimeException.class, () -> employeeService.removeEmployee(1));
    }


    @Test
    void removeEmployee_notFound(){
        assertThrows(RuntimeException.class, () -> employeeService.removeEmployee(150));
    }

    @Test
    void findEmployee_success(){
        Employee employee = new Employee(4, "Petrov Arkadiy", 100000, 2);
        employeeService.addEmployee(employee);
        assertEquals(employee, employeeService.findEmployee(4));
    }

    @Test
    void findEmployee_notFound(){
        assertThrows(RuntimeException.class, () -> employeeService.findEmployee(150));
    }

    @Test
    void getAllEmployees_empty(){
        assertTrue(employeeService.getAllEmployees().isEmpty());
    }
}
