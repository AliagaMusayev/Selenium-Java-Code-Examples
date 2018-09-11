package com.Mycompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);

        ArrayList list2 = new ArrayList();
        list2.add("asdad");
        list2.add(45);

        HashSet<String> names = new HashSet<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("a");
        names.add("d");
        names.add("z");

        System.out.println(names);

        HashSet<Integer> myList = new HashSet<>();
        Calculations calculations = new Calculations();
        myList = calculations.returnUniqueRandomNumbers(myList);

        System.out.println(myList);

        HashMap<String, String> myMap = new HashMap<String, String>();
        HashMapClass hasC = new HashMapClass();

        myMap = hasC.returnDictionary();

        for(String key:myMap.keySet()){
            System.out.println(key);
        }





    }
}
