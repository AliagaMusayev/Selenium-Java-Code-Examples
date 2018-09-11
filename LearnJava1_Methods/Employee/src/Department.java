public class Department extends Company{

    private int departmentID;
    private String departmentDescription;
    private Company departmentBelongsToCompany;

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public Company getDepartmentBelongsToCompany() {
        return departmentBelongsToCompany;
    }

    public void setDepartmentBelongsToCompany(Company departmentBelongsToCompany) {
        this.departmentBelongsToCompany = departmentBelongsToCompany;
    }
}
