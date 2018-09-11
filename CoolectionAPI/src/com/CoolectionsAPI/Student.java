package com.CoolectionsAPI;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Student<T> implements Comparable<Student>{
    String _name;
    int _age, _mark;

    public Student(String name, int age, int mark){
        this._name = name;
        this._age = age;
        this._mark = mark;
    }

    @Override
    public int compareTo(@Optional(Default = "test") Student student) {
        return _age > student._age ? 1 : -1;
    }

    @Override
    public String toString(){
        return "Student[name = " + _name + ", age = " + _age + ", mark = " + _mark + "]";
    }


    public <T extends GenericClass<? super T>> void testMetod(T t){


    }


    public <T extends GenericClass<? super T>> List<T> returnGenericList(){
        return new ArrayList<T>();
    }

    public void TestNullable(@Nullable int digit){

    }
}
