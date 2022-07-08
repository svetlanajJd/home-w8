package pro.sky.homew8;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private float salary;
    private int department;


    public Employee(String firstName, String lastName, int department, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getDepartment() {
        return this.department;
    }

    public float getSalary() {
        return this.salary;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + department + " " + salary;
    }

    @Override
    public boolean equals(Object other) {
        Employee employee = (Employee) other;
        boolean result;
        result = firstName.equals(employee.firstName) &
                lastName.equals(employee.lastName) &
                department == employee.department &
                salary == employee.salary;
        System.out.println(result);
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }
}