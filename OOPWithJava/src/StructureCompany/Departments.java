package StructureCompany;

import com.Mycompany.AbstractClass;

public class Departments extends AbstractClass {

    private String _departmentName;
    private int _departmentID;

    protected String get_departmentName() {
        return _departmentName;
    }

    protected void set_departmentName(String _departmentName) {
        this._departmentName = _departmentName;
    }

    protected int get_departmentID() {
        return _departmentID;
    }

    protected void set_departmentID(int _departmentID) {
        this._departmentID = _departmentID;
    }

    @Override
    public int returnSum() {
        return 0;
    }
}
