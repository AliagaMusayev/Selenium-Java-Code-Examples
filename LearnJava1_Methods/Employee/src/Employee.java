import java.lang.annotation.Documented;

public class Employee extends Department {

    private String employeeName;
    private  String employeeSurname;
    private int employeeAge;
    private int employeeDepartmentId;
    private double employeeSalary;


    public void setEmployeeName(String empName){

        this.employeeName=empName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }


    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeDepartmentId() {
        return employeeDepartmentId;
    }

    public void setEmployeeDepartmentId(int employeeDepartmentId) {
        this.employeeDepartmentId = employeeDepartmentId;
    }
}
