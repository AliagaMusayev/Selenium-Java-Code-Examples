package com.Mycompany;

public interface ICalculations {

    public double calculateSalary(long empID, String position, int countOfWorkDays);
    public double calculateVacationMoney(int countOfDays);
    public int countOfVacationDaysRemainingAndUsed(long empID);
    public void showMe();
}
