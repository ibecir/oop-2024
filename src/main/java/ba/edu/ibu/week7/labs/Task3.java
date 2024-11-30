package ba.edu.ibu.week7.labs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

record EmployeeRecord(String name, String position, double salary, LocalDate employmentDate) {

    public static EmployeeRecord createIntern(String name) {
        return new EmployeeRecord(name, "Intern", 1500.0, LocalDate.now());
    }

    public int yearsOfService() {
        LocalDate today = LocalDate.now();
        int years = today.getYear() - employmentDate.getYear();
        if (today.getMonthValue() < employmentDate.getMonthValue() ||
                (today.getMonthValue() == employmentDate.getMonthValue() && today.getDayOfMonth() < employmentDate.getDayOfMonth())) {
            years--;
        }
        return years;
    }
}

public class Task3 {
    public static void main(String[] args) {
        List<EmployeeRecord> employees = new ArrayList<>();
        employees.add(new EmployeeRecord("Alice", "Senior Developer", 80000.0, LocalDate.of(2015, 6, 15)));
        employees.add(new EmployeeRecord("Bob", "Developer", 60000.0, LocalDate.of(2018, 9, 10)));
        employees.add(new EmployeeRecord("Charlie", "Team Lead", 95000.0, LocalDate.of(2010, 3, 25)));
        employees.add(new EmployeeRecord("Diana", "Senior Developer", 85000.0, LocalDate.of(2012, 5, 1)));
        employees.add(EmployeeRecord.createIntern("Eve"));

        System.out.println("Employees with over 5 years of service:");
        for (EmployeeRecord employee : employees) {
            if (employee.yearsOfService() > 5) {
                System.out.println(employee);
            }
        }

        String department = "Senior Developer";
        double totalSalary = 0.0;
        int count = 0;
        for (EmployeeRecord employee : employees) {
            if (employee.position().equals(department)) {
                totalSalary += employee.salary();
                count++;
            }
        }
        double averageSalary = (count > 0) ? totalSalary / count : 0.0;
        System.out.println("\nAverage salary for '" + department + "': " + averageSalary);

        String role = "Senior Developer";
        System.out.println("\nEmployees in role '" + role + "':");
        for (EmployeeRecord employee : employees) {
            if (employee.position().equals(role)) {
                System.out.println(employee);
            }
        }
    }
}
