package com.example.demo.DBService;

import com.example.demo.model.Result;

import java.sql.*;

public class DbService {
     private static final String DB_URL = "jdbc:postgresql://localhost:5432/first-db";
     private static final String USER = "postgres";
     private static final String PASS = "root123";

     public  Connection getConnection() throws SQLException {
          try{
               System.out.println("Connecting to database...");
               Class.forName("org.postgresql.Driver");
               return DriverManager.getConnection(DB_URL,USER,PASS);
          } catch (Exception e) {
               return null;
          }
     }


     public Result addUser(String name,String surname, Result result) throws SQLException {

          String query = "{call add_users(?,?,?,?)}";
          CallableStatement pS = getConnection().prepareCall(query);

          pS.setString(1,name);
          pS.setString(2,surname);

          pS.registerOutParameter(3, Types.VARCHAR);
          pS.registerOutParameter(4, Types.BOOLEAN);

          pS.execute();

          result.setMessage(pS.getString(3));
          result.setSuccess(pS.getBoolean(4));

          return result;

     }

     public Result editUser(Integer id,String name,String surname, Result result) throws SQLException {
          String query = "{call edit_user(?,?,?,?,?)}";
          CallableStatement pS = getConnection().prepareCall(query);

          pS.setInt(1,id);
          pS.setString(2,name);
          pS.setString(3,surname);

          pS.registerOutParameter(4, Types.VARCHAR);
          pS.registerOutParameter(5, Types.BOOLEAN);

          pS.execute();
          result.setMessage(pS.getString(4));
          result.setSuccess(pS.getBoolean(5));

          return result;
     }


}
