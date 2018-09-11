package com.Mycompany;

import java.util.HashMap;

public class HashMapClass {

    HashMap<String, String> dict = new HashMap<>();

//    public HashMapClass(HashMap<String, String> myDict){
//        this.dict = myDict;
//    }

    public HashMap<String, String> returnDictionary(){

        dict.put("Ali","Musayev");
        dict.put("Hesen","Rza");

        return this.dict;
    }
}
