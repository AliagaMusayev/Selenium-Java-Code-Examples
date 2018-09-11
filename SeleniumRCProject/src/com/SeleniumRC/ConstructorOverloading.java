package com.SeleniumRC;

public class ConstructorOverloading extends ParentClassForAll{
    int _a;
    int _b;
    float _t;

    public  ConstructorOverloading(int a, int b, float t){

        super(t);
        this._t=t;
        this._a=a;
        this._b=b;
    }

    public  ConstructorOverloading(){}

    @Override
    public void show(){
        super.show();
        System.out.println("Child Class");
    }

    public void test(){

    }
}
