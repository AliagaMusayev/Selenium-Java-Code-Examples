package com.SeleniumRC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

//        AnonymousClass cls = new AnonymousClass(){
//            public void show(){
//                System.out.println("anonymous class");
//            }
//        };

        AnonymousClass ans = () -> System.out.println("Lambda expression");

        //((AnonymousClass) cls).show();
        ans.show();

        HashSet<String> set = new HashSet();
    set.add("test");
    System.out.println(set);
        // TODO : lambda expressions
        set.removeIf(a -> a.contentEquals("test"));
        System.out.println(set);

        // Single metod interfaces, hemcinin lambda interface de deye bilerik
//        ILambdaInterface lambdaInterface = (x,y) -> System.out.println(x+y);
//        lambdaInterface.calculate(10,20);

        ILambdaInterface lambdaInterface2 = (x,y,z) -> z = x + y;
        int result = 0;
        result = lambdaInterface2.returnSum(10,20, result);

        lambdaInterface2.showMe();
        ILambdaInterface.test();
        System.out.println("Result = " + result);

        // .net terefde olan using burda try ile evezlenir

//        try(FileInputStream stream = new FileInputStream("")){
//
//            stream.read();
//        }

        Scanner readFromUserInput = new Scanner(System.in);
        System.out.println("Enter a value");
        int myValue = readFromUserInput.nextInt();

        System.out.println("You were entered this value -> " + myValue);
    }
}
