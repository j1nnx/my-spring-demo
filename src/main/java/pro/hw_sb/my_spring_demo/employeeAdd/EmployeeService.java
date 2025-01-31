package pro.hw_sb.my_spring_demo.employeeAdd;

import org.springframework.stereotype.Service;
import pro.hw_sb.my_spring_demo.Employee;
import pro.hw_sb.my_spring_demo.error.EmployeeAlreadyAddedException;
import pro.hw_sb.my_spring_demo.error.EmployeeNotFoundException;
import pro.hw_sb.my_spring_demo.error.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInter{
    Map<String, Employee> EmployeeMap = new HashMap<>();

    private static final int MAX_EMPLOYEES = 10;
    @Override
    public Employee addEmployee(Employee employee) {
        if (EmployeeMap.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Employee storage is full.");
        }

        if (EmployeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Employee already exists.");
        }
        EmployeeMap.put(employee.getFullName(), employee);
        return employee;
    }
    @Override
    public Employee removeEmployee(String name, String lastname) {
        Employee employee = findEmployee(name, lastname);
        EmployeeMap.remove(employee.getFullName());
        return employee;
    }
    @Override
    public Employee findEmployee(String name, String lastName) {
        Employee employee = new Employee(name, lastName, 20000,3);
        if (EmployeeMap.containsKey(employee.getFullName())) {
            return EmployeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("dsd");

    }
    public Map<String, Employee> getEmployeeMap() {
        return EmployeeMap;


    }
}