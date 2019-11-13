package io.turntabl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static Connection dbConnect(){
        Connection db = null;
        String url = "jdbc:postgresql:northwind";
       try{
           Class.forName("org.postgresql.Driver");
           db = DriverManager.getConnection(url, "shadrack-ankomahene", "turntabl");
       }catch (SQLException | ClassNotFoundException sql){
           System.err.println("Connection err: " + sql);
       }
        return db;
    }
}
