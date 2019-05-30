package com.stackroute.jdbcDemo;

import java.sql.*;

public class JdbcBatchProcessingDemo {
    public void insertIntoCources() throws Exception {
        //register driver

            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Root@123");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into course values(?,?,?)");
            //ResultSet resultSet=preparedStatement.executeQuery();


            preparedStatement.setInt(1, 12);
            preparedStatement.setString(2, "MSC Maths");
            preparedStatement.setInt(3, 2);
            preparedStatement.addBatch();                   //adding first set of values to batch

            preparedStatement.setInt(1, 13);
            preparedStatement.setString(2, "Dip Agri");
            preparedStatement.setInt(3, 3);
            preparedStatement.addBatch();                   //adding second set of values to batch

            preparedStatement.setInt(1, 14);
            preparedStatement.setString(2, "Dip Arch");
            preparedStatement.setInt(3, 3);
            preparedStatement.addBatch();                   //adding third set of values to batch

            int result[]=preparedStatement.executeBatch();      //executing query
            //process the result
            int count=0;
            for (int i=0;i<result.length;i++)
            {
                count=count+result[i];
            }
            System.out.println(count+"Records inserted afterwards ");

            preparedStatement.close();
            connection.close();

        }
    }