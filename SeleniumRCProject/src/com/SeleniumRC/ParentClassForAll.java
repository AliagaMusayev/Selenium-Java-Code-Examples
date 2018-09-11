package com.SeleniumRC;

public class ParentClassForAll {

    float _t;
    public ParentClassForAll(float t){
        this._t=t;
        System.out.println(_t);
    }

    public ParentClassForAll() {
    }

    public float get_t() {
        return _t;
    }

    public void show(){
        System.out.println("Parent Class");
    }
}
