package pro.sky.homew8;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.max;

@Service
public class EmployeeDepartmentService {
    private final EmployeeService employeeService;

    public EmployeeDepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> all() {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        listContactsDepartment.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return listContactsDepartment;
    }

    public Optional<Employee> maxSalary(int department) {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        Optional<Employee> streamContactsDepartment = listContactsDepartment.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .filter(d -> d.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> (int) employee.getSalary()));
        return streamContactsDepartment;
    }

    public Optional<Employee> minSalary(int department) {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        Optional<Employee> streamContactsDepartment = listContactsDepartment.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .filter(d -> d.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> (int) employee.getSalary()));
        return streamContactsDepartment;
    }
}

