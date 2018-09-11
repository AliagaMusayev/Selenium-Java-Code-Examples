package com.Mycompany;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAPI {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String x = "click";
        // burada mentiq beledir:
        // ReflectionAPI clasindaki adi x-a beraber yeni click olan ve iki String parameter qebul eden metodu tap
        Method method = ReflectionAPI.class.getMethod(x,String.class,String.class);

        //burda ise yuxarida tapdigi metodu invokde edir
        method.invoke(method,"Salam","Dunya");
        System.out.println("Runned");
    }

    public static void click(String x, String y){
        System.out.println("Executing the Test : "+x + " " + y);
    }
}
