package pro.hw_sb.my_spring_demo.service.api;

import pro.hw_sb.my_spring_demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void removeEmployee(int id);
    Employee findEmployee(int id);
    List<Employee> getAllEmployees();
}
