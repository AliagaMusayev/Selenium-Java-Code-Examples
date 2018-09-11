package com.WorkWithXML;

public class Students {

    private String _name;
    private  String _surname;
    private  int _age;

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_surname() {
        return _surname;
    }

    public void set_surname(String _surname) {
        this._surname = _surname;
    }

    public int get_age() {
        return _age;
    }

    public void set_age(int _age) {
        this._age = _age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "_name='" + _name + '\'' +
                ", _surname='" + _surname + '\'' +
                ", _age=" + _age +
                '}';
    }
}
