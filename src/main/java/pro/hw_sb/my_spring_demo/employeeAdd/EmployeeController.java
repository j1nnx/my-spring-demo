package pro.hw_sb.my_spring_demo.employeeAdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.hw_sb.my_spring_demo.Employee;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("salary") int salary, @RequestParam("department") int department) {
        // Ваш код для обработки запроса
        Employee employee = new Employee(name, lastName, salary, department);
        return employeeService.addEmployee(employee);

    }

    @GetMapping(path = "/find")
    public Employee getId(@RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("salary") int salary, @RequestParam("department") int department) {
        // Ваш код для обработки запроса
        return employeeService.findEmployee(name, lastName);
    }


    @GetMapping(path = "/del")
    public Employee delete(@RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("salary") int salary, @RequestParam("department") int department) {
        return employeeService.removeEmployee(name, lastName);

    }
}
