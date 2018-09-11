package com.SQLPreparedStatement;

import java.sql.Connection;

public interface IDBOperations {

    boolean IsConnectionAvailable(Connection connection);

    int InsertDataToDB(String fullPathToDB, Connection connection, String SQLQuery);

    <T> T DeleteData(T selectionCriteria);

    <T> T UpdateData(T updateCriteria);
}
