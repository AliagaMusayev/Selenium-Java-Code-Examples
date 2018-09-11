package com.SQLPreparedStatement;

public class BaseClass {
  protected static String pathToDB;
  protected static String DBUrl;
    static{
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            pathToDB = "MyDB/MyDB.accdb";
            DBUrl = "jdbc:ucanaccess://"+pathToDB;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
