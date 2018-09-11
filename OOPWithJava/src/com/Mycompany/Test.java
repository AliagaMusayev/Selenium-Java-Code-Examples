package com.Mycompany;

import Humans.Directors;

public class Test extends Directors implements ICalculations{

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

    public void showMe(){

    }
}
