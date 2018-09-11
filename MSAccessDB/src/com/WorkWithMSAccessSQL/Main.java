package com.WorkWithMSAccessSQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
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

            boolean ifTrue = resultSet.last();
            int row = resultSet.getRow();

            resultSet.beforeFirst();
            //resultSet.next();
            //int row = resultSet.getRow();
//            Array result = resultSet.getArray(1);


            while(resultSet.next()){
                Student std = new Student();
                System.out.println(resultSet.getString("StdName"));
                std.setStdname(resultSet.getString("StdName"));
                studentList.add(std);
                WorkWithXML.WriteDataToXML(studentList);
            }
        }

        catch (SQLException ex){

            ex.printStackTrace();
        }


    }
}
