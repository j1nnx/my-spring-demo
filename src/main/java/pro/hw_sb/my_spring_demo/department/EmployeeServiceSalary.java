package pro.hw_sb.my_spring_demo.department;

import org.springframework.stereotype.Service;
import pro.hw_sb.my_spring_demo.Employee;
import pro.hw_sb.my_spring_demo.EmployeeServiceSalaryInter;
import pro.hw_sb.my_spring_demo.employeeAdd.EmployeeService;
import pro.hw_sb.my_spring_demo.error.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeServiceSalary implements EmployeeServiceSalaryInter {

    private final EmployeeService employeeService;

    public  EmployeeServiceSalary(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryEmployeeByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("No" + " " + department));
    }
    @Override
    public Employee findMinSalaryEmployeeByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("NO" + " " + department));
    }
    @Override
    public List<Employee> allEmployeesByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }



    @Override
    public Map<Integer, List<Employee>> allEmployeesDepartments() {
        return employeeService.getEmployeeMap().values().stream()
                .collect(groupingBy(Employee::getDepartment));
    }

}
