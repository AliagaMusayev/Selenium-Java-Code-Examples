package com.WorkWithMSAccessSQL;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Hashtable;

public class TestNGClass {

    @Test(dataProvider = "providerMethod")
    public void showData(Hashtable<String, String> myTable){
        System.out.println("Name of student -> " + myTable.get("StudentName"));
    }

    @DataProvider
    public Object[][] providerMethod() throws SQLException {

        Connection connection;
        Statement statement;
        ResultSet resultSet = null;
        String pathToDB = "C:\\Users\\aliaga.musayev\\IdeaProjects\\MSAccessDB\\DB\\MyDB.accdb";
        String DBUrl = "jdbc:ucanaccess://"+pathToDB;

        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DBUrl);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = statement.executeQuery("Select StdName from Student");
        }
        catch (Exception ex){

        }
        int rowCount = BaseClass.getCountOfRows(resultSet);

        Object[][] obj = new Object[rowCount][1];

        Hashtable<String, String> myHashTable;
        String name;
        int counter=0;
        while(resultSet.next()) {
            myHashTable = new Hashtable<>();
            name = resultSet.getString("StdName");
            myHashTable.put("StudentName", name);
            obj[counter][0] = myHashTable;
            counter++;
        }

        return obj;
    }

}
