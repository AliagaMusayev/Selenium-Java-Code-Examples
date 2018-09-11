public class MainIntializerClass {

    public static void main(String args[]){
        Employee newEmp = new Employee();
        newEmp.setEmployeeName("Aliaga");
        newEmp.setEmployeeSurname("Musayev");
        newEmp.setEmployeeAge(29);
        newEmp.setEmployeeDepartmentId(100);
        newEmp.setEmployeeSalary(1000);

        Company company = new Company();
        company.setCompanyName("AccessBank Azerbaijan");

        Department dep = new Department();
        dep.setDepartmentID(100);
        dep.setDepartmentDescription("IT Research and Development");
        dep.setDepartmentBelongsToCompany(company);

        MainIntializerClass mainClass = new MainIntializerClass();
        mainClass.printFullInfoAboutEmployee(newEmp,dep);

    }


    private void printFullInfoAboutEmployee(Employee emp, Department dep){

        System.out.println("Name of Employee : " + emp.getEmployeeName()
        + "\nSurname of Employee : " + emp.getEmployeeSurname());
    }
}
