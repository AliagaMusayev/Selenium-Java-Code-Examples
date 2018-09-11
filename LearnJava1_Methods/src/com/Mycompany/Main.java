package com.Mycompany;


public class Main {

    public static void main(String[] args) throws IllegalArgumentException {

        ChildClass child1 = new ChildClass();
        ParentClass p1 = new ChildClass();
        ((ChildClass) p1).run();
        ParentClass.printMessage();
        child1.run();
        Main.test();
    }

    public static void test() throws IllegalArgumentException{

        int a = 10/0;
        //throw new Exception("zzzzzzzzzzzz");
//        try{
//
//        }
//        catch (Throwable ex)
//        {
//
//        }
//        finally {
//
//        }
        //ParentClass.printMessage();
        System.out.println("test");
    }



}