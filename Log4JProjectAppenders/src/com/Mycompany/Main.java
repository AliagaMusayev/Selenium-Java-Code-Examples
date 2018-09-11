package com.Mycompany;

import org.apache.log4j.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws Exception {

        System.out.println("System were run");
        logger.debug("Test");
        logger.info("test");
        try{
            int a = 10/2;
        }

        catch (Exception ex){
            logger.error(ex.getMessage());
        }

        Employees emp = new Employees();
        int z = emp.devideDigits(10,0);
    }
}
