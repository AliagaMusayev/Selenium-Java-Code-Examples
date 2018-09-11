package com.SQLPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DBOperations implements IDBOperations {
    @Override
    public boolean IsConnectionAvailable(Connection connection) {
        try {
            if(!connection.isValid(10))
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    private static DBOperations operations;



    //"insert into"+TableName+" values (?,?)"
    @Override
    public int InsertDataToDB(String fullPathToDB, Connection connection, String SQLQuery) {
        try {
            connection = DriverManager.getConnection(fullPathToDB);
            PreparedStatement statement = connection.prepareStatement(SQLQuery);
            PrepareStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public <T> T DeleteData(T selectionCriteria) {
        return null;
    }

    @Override
    public <T> T UpdateData(T updateCriteria) {
        return null;
    }

    public abstract PreparedStatement PrepareStatement(PreparedStatement statement);

    public static DBOperations getOperations() {
        return operations;
    }
}
