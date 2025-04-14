package com.example.demo.DBService;

import com.example.demo.model.Result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbService {
     private static final String DB_URL = "jdbc:postgresql://localhost:5432/first-db";
     private static final String USER = "postgres";
     private static final String PASS = "root123";

     public  Connection getConnection() throws SQLException {
          try{
               return DriverManager.getConnection(DB_URL,USER,PASS);
          } catch (Exception e) {
               return null;
          }
     }


     public Result addUser(){
          getConnection().prepareStatement("select * from users");
     }
}
