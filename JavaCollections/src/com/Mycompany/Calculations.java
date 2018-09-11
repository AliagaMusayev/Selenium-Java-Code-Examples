package com.Mycompany;

import java.util.HashSet;

public class Calculations {

    public HashSet<Integer> returnUniqueRandomNumbers(HashSet<Integer> myNumberList){

        while(myNumberList.size()<100){
            myNumberList.add((int)(Math.random()*100));
        }
        return myNumberList;
    }
}
