package pro.hw_sb.my_spring_demo.service.impl;

import org.springframework.stereotype.Service;
import pro.hw_sb.my_spring_demo.model.Employee;
import pro.hw_sb.my_spring_demo.service.api.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        if (employees.stream().anyMatch(e -> e.getId() == employee.getId())) {
            throw new RuntimeException("Employee with ID " + employee.getId() + " already exists");
        }
        employees.add(employee);
    }

    @Override
    public void removeEmployee(int id) {
        Employee employee = findEmployee(id);
        employees.remove(employee);
    }

    @Override
    public Employee findEmployee(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
