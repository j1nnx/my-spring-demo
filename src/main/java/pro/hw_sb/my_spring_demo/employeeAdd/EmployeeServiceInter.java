package pro.hw_sb.my_spring_demo.employeeAdd;

import pro.hw_sb.my_spring_demo.Employee;

public interface EmployeeServiceInter {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(String name, String lastname);

    Employee findEmployee(String name, String lastName);
}
