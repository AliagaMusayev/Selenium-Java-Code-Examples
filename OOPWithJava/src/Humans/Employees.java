package Humans;

import com.Mycompany.ICalculations;

public class Employees implements ICalculations {

    private String _name;
    private String _surname;
    private int _age;
    private int _departmentID;

    protected String get_name() {
        return _name;
    }

    protected void set_name(String _name) {
        this._name = _name;
    }

    protected String get_surname() {
        return _surname;
    }

    protected void set_surname(String _surname) {
        this._surname = _surname;
    }

    protected int get_age() {
        return _age;
    }

    protected int get_departmentID() {
        return _departmentID;
    }

    protected void set_departmentID(int _departmentID) {
        this._departmentID = _departmentID;
    }

    @Override
    public double calculateSalary(long empID, String position, int countOfWorkDays) {
        return 0;
    }

    @Override
    public double calculateVacationMoney(int countOfDays) {
        return 0;
    }

    @Override
        public int countOfVacationDaysRemainingAndUsed(long empID) {
        return 0;
    }

    @Override
    public void showMe() {

    }


}
