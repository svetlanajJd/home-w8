package pro.sky.homew8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments/")
public class EmployeeDepartmentController {
    private EmployeeDepartmentService employeeDepartmentService;

    public EmployeeDepartmentController(EmployeeDepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }

    @GetMapping("/all")
    public List<Employee> all() {
        return employeeDepartmentService.all();
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalary(@RequestParam("departmentID") int department) {
        return employeeDepartmentService.maxSalary(department);
    }

    @GetMapping("/min-salary")
    public Optional<Employee> minSalary(@RequestParam("departmentID") int department) {
        return employeeDepartmentService.minSalary(department);
    }
}