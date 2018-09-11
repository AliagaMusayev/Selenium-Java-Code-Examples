package com.Mycompany;


import org.apache.log4j.Logger;

public class Employees {

    static Logger logger = Logger.getLogger(Employees.class);

    public int devideDigits(int a, int b) throws Exception {
        try {
            return a / b;
        }
        catch (ArithmeticException ex){
            logger.error("There is a problem on devideDigits method => "+ ex.getMessage());
            throw new Exception("There is a problem on method. Please refer to log file");
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new Exception("There is a problem on method. Please refer to log file");
        }
    }
}