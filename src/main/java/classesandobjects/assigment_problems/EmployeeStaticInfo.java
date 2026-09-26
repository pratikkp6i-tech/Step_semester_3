package classesandobjects.assigment_problems;

public class EmployeeStaticInfo {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStaticInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeStaticInfo("Asha", 40000);
        new EmployeeStaticInfo("Ravi", 42000);
        new EmployeeStaticInfo("Meena", 39000);

        System.out.println("3 Employee objects created");
        EmployeeStaticInfo.printCompanyInfo();
    }
}
