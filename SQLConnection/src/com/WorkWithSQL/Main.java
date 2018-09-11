package com.WorkWithSQL;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {

    private static String url ;
    private static String usrName;
    private static String password;
    private static String query;

    public Main(){
        setUrl("jdbc:sqlserver//.....");
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

        //Main main = new Main();
        Class.forName("Test");

        setUsrName("username");
        setPassword("passwword");
        setQuery("select ....");

        CreatePropertiesFile(getUrl(),getUsrName(),getPassword());
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(getUrl(), getUsrName(), getPassword());
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getQuery());

            while(result.next()){
                System.out.println(result.getString("ContractNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            statement.close();
            connection.close();
        }

    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Main.url = url;
    }

    public static String getUsrName() {
        return usrName;
    }

    public static void setUsrName(String usrName) {
        Main.usrName = usrName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Main.password = password;
    }

    public static String getQuery() {
        return query;
    }

    public static void setQuery(String query) {
        Main.query = query;
    }


    public void insertDataIntoTable(String ContractNumber, String CustomerNumber) throws ClassNotFoundException, SQLException {
        setUsrName("username");
        setPassword("passwword");
        setQuery("insert into lfs.Loans(ContractNumber, CustomerNumber) values (?,?)");

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
             conn = DriverManager.getConnection(getUrl(),getUsrName(),getPassword());
             stmt = conn.prepareStatement(getQuery());
             stmt.setString(1, ContractNumber);
             stmt.setString(2, CustomerNumber);

             stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            stmt.close();
            conn.close();
        }
    }

    public static void CreatePropertiesFile(String connectionURL, String userName, String password){
        Properties propertiesFile = new Properties();
        propertiesFile.setProperty("connectionURL", connectionURL);
        propertiesFile.setProperty("userName", userName);
        propertiesFile.setProperty("password", password);

        try (FileWriter writer = new FileWriter("MyProperties2.properties")) {
            propertiesFile.store(writer,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

class Test{
    static {
        System.out.println("Test classes static section");
    }
}
