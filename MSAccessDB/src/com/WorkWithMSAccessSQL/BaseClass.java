package com.WorkWithMSAccessSQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseClass {

    public static int getCountOfRows(ResultSet resultSet){
        int countOfRows = 0;
        if(resultSet!=null) {
            try {
                resultSet.last();
                countOfRows = resultSet.getRow();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    resultSet.beforeFirst();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
            return  countOfRows;
    }
}
