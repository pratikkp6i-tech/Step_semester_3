package oop.assigment_problems;

public class EmployeeDefaults {
    String empName;
    double salary;
    boolean permanent;

    public static void main(String[] args) {
        EmployeeDefaults emp = new EmployeeDefaults();
        System.out.println("Name: " + emp.empName);
        System.out.println("Salary: " + emp.salary);
        System.out.println("Permanent: " + emp.permanent);
    }
}
