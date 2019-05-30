package com.stackroute.jdbcDemo;

import com.mysql.cj.jdbc.DatabaseMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetadataDemo {
    public void getMetadata() throws SQLException, ClassNotFoundException {

        Connection connection = null;
        DatabaseMetaData databaseMetadata;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Root@123");

            //display metadata
           databaseMetadata= (DatabaseMetaData) connection.getMetaData();
           if (databaseMetadata!=null){
               System.out.println("Database version: "+databaseMetadata.getDatabaseProductVersion());
           }
            //about database
            System.out.println("Driver name : "+databaseMetadata.getDriverName());

            System.out.println("URL: " +
                    databaseMetadata.getURL());
            System.out.println("User Name: " +
                    databaseMetadata.getUserName());
            System.out.println(
                    (databaseMetadata.supportsANSI92FullSQL() ?
                            "ANSI92FullSQL supported." :
                            "ANSI92FullSQL not supported."));
            System.out.println(
                    (databaseMetadata.supportsTransactions() ?
                            "Transaction supported." :
                            "Transaction not supported."));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }
}
