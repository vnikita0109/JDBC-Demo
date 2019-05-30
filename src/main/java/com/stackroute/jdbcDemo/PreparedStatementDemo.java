package com.stackroute.jdbcDemo;

import java.sql.*;

public class PreparedStatementDemo {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    public  void getCourseByName(String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Root@123");
            preparedStatement=connection.prepareStatement("select * from course where courseName=?");
            preparedStatement.setString(1,"name");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                int duration=resultSet.getInt(3);
                System.out.println(id+" "+name+" "+duration);
            }


        } catch (ClassNotFoundException cnfException) {
            System.out.println("Exception thrown"+cnfException.getStackTrace());

        } catch (SQLException sqlException) {
            System.out.println("Exception thrown"+sqlException.getStackTrace());
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void getCourseByNameAndDuration(String name,int duration){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Root@123");
            preparedStatement=connection.prepareStatement("select * from course where courseName=? AND duration=?");
            preparedStatement.setString(1,"name");
            preparedStatement.setString(2,"duration");

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                System.out.println(id+" "+name+" "+duration);
            }
        } catch (ClassNotFoundException cnfException) {
            System.out.println("Exception thrown"+cnfException.getStackTrace());

        } catch (SQLException sqlException) {
            System.out.println("Exception thrown"+sqlException.getStackTrace());
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
