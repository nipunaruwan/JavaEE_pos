package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private static Dbconnection dbconnection;
    private Connection connection;
    private Dbconnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","1234");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

  public static Dbconnection getdbconnection(){
      return dbconnection==null?dbconnection=new Dbconnection():dbconnection;
  }
  public Connection getConnection(){
        return connection;
  }
}
