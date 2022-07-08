package pro.sky.homew8;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<String,Employee> contacts = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName, int department, float salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        String key=getKey(firstName, lastName, department, salary);
        if (contacts.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        contacts.put(key,employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName, int department, float salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (contacts.containsKey(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee removeEmployee(String firstName, String lastName, int department, float salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (contacts.containsKey(employee)) {
            contacts.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Map <String,Employee> printTotal() {
        return new HashMap<>(contacts);
    }
    private String getKey(String firstName,
                          String lastName,
                          int department,
                          float salary){
        return firstName+" "+lastName+" "+department+" "+salary;
    }

}