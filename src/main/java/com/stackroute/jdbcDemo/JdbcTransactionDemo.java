package com.stackroute.jdbcDemo;

import java.sql.*;

public class JdbcTransactionDemo {
    public void checkTransactions() throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatementInsert=null;
        PreparedStatement preparedStatementUpdate=null;

        String insertQuery="insert into courses values(?,?,?)";
        String updateQuery="update courses set course=? where id=?";
       // Savepoint savepoint=null;

        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Root@123");

            connection.setAutoCommit(false);
            preparedStatementInsert=connection.prepareStatement(insertQuery);
            preparedStatementInsert.setInt(1,11);
            preparedStatementInsert.setString(2,"Dip HM");
            preparedStatementInsert.setInt(3,2);
            preparedStatementInsert.executeUpdate();

           // savepoint=connection.setSavepoint("savepoint1");

            preparedStatementUpdate=connection.prepareStatement(updateQuery);
            preparedStatementUpdate.setString(2,"History");
            preparedStatementUpdate.setInt(1,12);
            preparedStatementUpdate.executeUpdate();

            connection.commit();

            System.out.println("It's done!!");
        } catch (SQLException exception) {
            System.out.println("There is a problem   "+exception.getStackTrace());
            connection.rollback();
        }
        finally {
            preparedStatementInsert.close();
            preparedStatementUpdate.close();
            connection.close();

        }
    }
}
