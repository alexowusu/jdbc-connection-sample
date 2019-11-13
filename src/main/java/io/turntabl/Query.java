package io.turntabl;

import java.sql.*;

public class Query {
    private Connection db = ConnectDB.dbConnect();
    private Statement stmt;
    private ResultSet rs;

    public void getAllCustomers(){
        try {
            String sql = "select * from customers";
            setStmt(getDb().createStatement());
            setRs(getStmt().executeQuery(sql));
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%30s %30s %30s %40s %15s %20s", "CONTACT NAME", "COMPANY NAME", "CONTACT TITLE", "ADDRESS", "CITY", "REGION");
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            while (getRs().next()){
                System.out.format("%30s %30s %30s %40s %15s %20s",
                        getRs().getString("contact_name"),
                                getRs().getString("company_name"),
                                getRs().getString("contact_title"),
                                getRs().getString("address"),
                                getRs().getString("city"),
                                getRs().getString("region")
                );
                System.out.println();
            }
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            getStmt().close();
        }catch (SQLException sqle){
            System.err.println(sqle);
        }

    }

    public void showSimilarCustomers(String name){
        try{
            String sql = "select contact_name from customers where contact_name like '" + name +"%'";
            setStmt(getDb().createStatement());
            setRs(getStmt().executeQuery(sql));

            System.out.println("-----------------");
            System.out.printf("%15s", "CONTACT NAME");
            System.out.println("\n-----------------");
            while (getRs().next()){
                System.out.format("%15s", getRs().getString("contact_name"));
                System.out.println();
            }
            System.out.println("\n-----------------");
            getStmt().close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void setDb(Connection db) {
        this.db = db;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Connection getDb() {
        return db;
    }

    public Statement getStmt() {
        return stmt;
    }

    public ResultSet getRs() {
        return rs;
    }
}
