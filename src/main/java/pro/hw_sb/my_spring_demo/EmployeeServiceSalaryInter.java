package pro.hw_sb.my_spring_demo;

import java.util.List;
import java.util.Map;

public interface EmployeeServiceSalaryInter {
    Employee findMaxSalaryEmployeeByDepartment(int department);

    Employee findMinSalaryEmployeeByDepartment(int department);

    List<Employee> allEmployeesByDepartment(int department);

    Map<Integer, List<Employee>> allEmployeesDepartments();


}
