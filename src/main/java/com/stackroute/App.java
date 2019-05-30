package com.stackroute;

import com.stackroute.jdbcDemo.*;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        DataManager dataManager=new DataManager();
        dataManager.getAllCourcess();

        PreparedStatementDemo preparedStatementDemo=new PreparedStatementDemo();
        preparedStatementDemo.getCourseByName("Zoology");
        preparedStatementDemo.getCourseByNameAndDuration("Botony",4);

        JdbcBatchProcessingDemo jdbcBatchProcessingDemo=new JdbcBatchProcessingDemo();
        jdbcBatchProcessingDemo.insertIntoCources();
        dataManager.getAllCourcess();

        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
        databaseMetadataDemo.getMetadata();

        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.checkTransactions();
        dataManager.getAllCourcess();

        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
        resultSetMetadataDemo.getResultMatadata();
    }
}
