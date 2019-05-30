package com.stackroute.jdbcDemo;

import java.sql.*;

public class DataManager {
    public void getAllCourcess() throws ClassNotFoundException, SQLException {
        //register driver
        try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Root@123");
            Statement statement=connection.createStatement()){
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection

            ResultSet resultSet=statement.executeQuery("select * from course");

            while (resultSet.next())
            {
                int id=resultSet.getInt(1);
                String courseName=resultSet.getString(2);
                int duration=resultSet.getInt(3);
                System.out.println(id+" "+courseName+" "+duration);
            }
        } catch (ClassNotFoundException cnfException) {
            System.out.println("Exception thrown, give a class"+cnfException.getStackTrace());
        } catch (SQLException sqlException) {
            System.out.println("Exception of sql thrown"+sqlException.getStackTrace());
        }
    }
}
