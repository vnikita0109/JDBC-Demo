package com.stackroute.jdbcDemo;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void getResultMatadata() throws ClassNotFoundException, SQLException {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Root@123");
            Statement statement = connection.createStatement();
            ps=connection.prepareStatement("select * from emp");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();

            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));


        } catch (ClassNotFoundException e) {
           System.out.println("Exception thrown"+e.getStackTrace());
       } catch (SQLException e) {
           System.out.println("Another exception thrown"+e.getStackTrace());
       }
       finally {
            connection.close();
            ps.close();
       }
    }
}
