package com.SeleniumRC;

public interface ILambdaInterface {

//    void calculate(int x, int y);

    int returnSum(int x, int y, int c);

    // default keyword yazmaqla interface icinde metod implement ede bilerik
    default void showMe(){
        System.out.println("I am in ILambdaInterface");
    }

    // static keyword yazmaqla interface icinde metod implement ede bilerik
    static void test(){

        System.out.println("sdfsdfsdfsdfsdfsdf");
    }
}
