package pro.hw_sb.my_spring_demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pro.hw_sb.my_spring_demo.model.Employee;
import pro.hw_sb.my_spring_demo.service.api.DepartmentService;
import pro.hw_sb.my_spring_demo.service.api.EmployeeService;
import pro.hw_sb.my_spring_demo.service.impl.DepartmentServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmployeesByDepartment_success() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Arkadiy", 50000, 1),
                new Employee(2, "Dima", 60000, 1),
                new Employee(3, "Sasha", 70000, 2)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        List<Employee> result = departmentService.getEmployeesByDepartment(1);
        assertEquals(2, result.size());
        assertEquals("Arkadiy", result.get(0).getName());
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void getSalarySumByDepartment_success() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Damir", 50000, 1),
                new Employee(2, "Evgeniy", 60000, 1)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        double sum = departmentService.getSalarySumByDepartment(1);
        assertEquals(110000, sum);
    }

    @Test
    void getMaxSalaryByDepartment_noEmployees() {
        when(employeeService.getAllEmployees()).thenReturn(List.of());
        assertThrows(RuntimeException.class, () -> departmentService.getMaxSalaryByDepartment(1));
    }

    @Test
    void getMinSalaryByDepartment_success() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Roma", 50000, 1),
                new Employee(2, "Bogdan", 60000, 1)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        double minSalary = departmentService.getMinSalaryByDepartment(1);
        assertEquals(50000, minSalary);
    }

    @Test
    void getEmployeesGroupedByDepartment_success() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Maxim", 50000, 1),
                new Employee(2, "Egor", 60000, 2)
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        Map<Integer, List<Employee>> result = departmentService.getEmployeesGroupedByDepartment();
        assertEquals(1, result.get(1).size());
        assertEquals(1, result.get(2).size());
    }
}
