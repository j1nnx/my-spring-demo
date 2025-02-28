package pro.hw_sb.my_spring_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.hw_sb.my_spring_demo.model.Employee;
import pro.hw_sb.my_spring_demo.service.api.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSalarySumByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getSalarySumByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalaryByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalaryByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return departmentService.getEmployeesGroupedByDepartment();
    }
}
