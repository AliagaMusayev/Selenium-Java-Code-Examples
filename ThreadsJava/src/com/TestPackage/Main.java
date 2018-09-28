package com.TestPackage;

public class Main {

    public static void main(String[] args) {

        Thread th1 = new Thread(()->{

            for (int i =0;i<=1000;i++){
                System.out.println(i);
            }
        });

        th1.start();
    }
}
