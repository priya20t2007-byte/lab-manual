import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + department + "\t" + salary;
    }
}

public class EmployeeAnalytics {

    public static void main(String[] args) {

        // Employee Data
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Rahul", "CSE", 55000.0),
                new Employee(102, "Sneha", "ECE", 62000.0),
                new Employee(103, "Kiran", "CSE", 48000.0),
                new Employee(104, "Divya", "MECH", 51000.0),
                new Employee(105, "Arjun", "ECE", 70000.0)
        );

        // Display all employees
        System.out.println("---- All Employees ----");
        employees.forEach(System.out::println);

        // Salary above 50000 (High to Low)
        System.out.println("\n---- Salary Above 50000 (High to Low) ----");
        employees.stream()
                .filter(e -> e.salary > 50000)
                .sorted((a, b) -> Double.compare(b.salary, a.salary))
                .forEach(e -> System.out.println(e.name + " -> " + e.salary));

        // Employee names
        System.out.println("\n---- Employee Names ----");
        List<String> names = employees.stream()
                .map(e -> e.name)
                .collect(Collectors.toList());
        System.out.println(names);

        // Group employees by department
        System.out.println("\n---- Employees Grouped by Department ----");
        Map<String, List<String>> grouped = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        LinkedHashMap::new,
                        Collectors.mapping(e -> e.name, Collectors.toList())
                ));

        grouped.forEach((dept, list) ->
                System.out.println(dept + " : " + list));

        // Average salary per department
        System.out.println("\n---- Average Salary per Department ----");
        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(e -> e.salary)
                ));

        averageSalary.forEach((dept, avg) ->
                System.out.printf("%s : %.2f%n", dept, avg));

        // Total salary
        double totalSalary = employees.stream()
                .map(e -> e.salary)
                .reduce(0.0, Double::sum);

        System.out.printf("%nTotal Salary Paid : %.2f%n", totalSalary);

        // Count CSE employees
        long count = employees.stream()
                .filter(e -> e.department.equals("CSE"))
                .count();

        System.out.println("Number of CSE Employees : " + count);

        // Highest paid employee
        Employee highest = employees.stream()
                .max(Comparator.comparingDouble(e -> e.salary))
                .get();

        System.out.println("Highest Paid : " + highest.name + " (" + highest.salary + ")");
    }
}
