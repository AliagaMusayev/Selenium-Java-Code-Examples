package com.Mycompany;


import org.apache.log4j.Logger;
import org.apache.log4j.spi.ErrorCode;

public class Main {

    public static void main(String[] args) {
        Logger myLogs = Logger.getLogger("devpinoyLogger");
        Logger myLogs2 = Logger.getLogger("rootLogger");
        System.out.println("test");
        try{
            int a = 10/0;
        }
        catch (Exception ex){
            myLogs.debug("Error"+": devide "+ex.getMessage()+" "+ex.getStackTrace());
            myLogs2.debug(ex.getMessage());
        }

    }
}
