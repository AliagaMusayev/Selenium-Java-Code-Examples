package com.CoolectionsAPI;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList();
        ArrayList<String> myStringList = new ArrayList<>();
        Set<Double> mySet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        HashMap<String, Integer> myDictionary = new HashMap<>();

        myList.add(23);
        myList.add(58);
        myList.add(5);
        myList.add(1);
        myList.add(35);

        myList.sort((i,j) -> i>j ? 1 : -1);

        // TreeSet ozu sort edir
        treeSet.add(23);
        treeSet.add(58);
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(35);

        Collections.sort(myList);
        System.out.println("myList after sort -> "+myList);

        System.out.println("TreeSet -> "+treeSet);

        List<Student> students = new ArrayList<>();

        students.add(new Student("Aliaga", 29, 90));
        students.add(new Student("Tapdiq", 56, 66));
        students.add(new Student("Ramin", 18, 100));
        students.add(new Student("Osman", 73, 50));

        Collections.sort(students);
        System.out.println(students);

        Collections.sort(students,(i,j)->i._mark > j._mark ? 1 : -1);

        System.out.println(students);

        // Enums
        int valueOfHigh = Enums.High.getEnumValue();

        System.out.println("Value of enum -> " + valueOfHigh);
        System.out.println(Enums.High.NormalizeEnum());
        System.out.println(Enums.Medium.NormalizeEnum());
        System.out.println(Enums.Low.NormalizeEnum());

    }
}
