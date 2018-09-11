package com.Mycompany;

import Humans.Directors;
import Humans.Employees;
import Humans.Workers;

public class Main {

    public static void main(String[] args) {

        ICalculations calc = new Directors();
        int daysRemainingAndUsed = calc.countOfVacationDaysRemainingAndUsed(125);
        System.out.println(daysRemainingAndUsed);
    }
}
