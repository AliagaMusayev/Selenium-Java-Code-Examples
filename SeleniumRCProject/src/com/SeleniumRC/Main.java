package com.SeleniumRC;

public class Main {

    public static void main(String[] args) {

        ParentClassForAll cos = new ConstructorOverloading(10,20, 20);
        System.out.println(cos.get_t());

        ParentClassForAll p = new ConstructorOverloading();
        p.show();
        ((ConstructorOverloading) p).test();
    }
}
