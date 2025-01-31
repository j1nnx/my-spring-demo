package pro.hw_sb.my_spring_demo.department;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.hw_sb.my_spring_demo.Employee;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeControllerSalary {

    private final EmployeeServiceSalary employeeServiceSalary;

    private EmployeeControllerSalary(EmployeeServiceSalary employeeServiceSalary){
        this.employeeServiceSalary = employeeServiceSalary;
    }

    @GetMapping(path = "/departments/max-salary")
    public String findMaxSalaryEmployeeByDepartment(@RequestParam("departmentId") int department){
        Employee employee = employeeServiceSalary.findMaxSalaryEmployeeByDepartment(department);
        return employee.getLastName() + " " + employee.getFirstName() + " " + employee.getSalary();
    }

    @GetMapping(path = "/departments/min-salary")
    public String findMinSalaryEmployeeByDepartment(@RequestParam("departmentId") int department){
        Employee employee = employeeServiceSalary.findMinSalaryEmployeeByDepartment(department);
        return employee.getLastName() + " " + employee.getFirstName() + " " + employee.getSalary();
    }

    @GetMapping(path = "/departments/all")
    public List<Employee> allEmployeesByDepartment(@RequestParam("departmentId") int department){
        return employeeServiceSalary.allEmployeesByDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getTopEmployeesByDepartment(){
        return employeeServiceSalary.allEmployeesDepartments();
    }
}
