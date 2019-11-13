package io.turntabl;

import java.sql.*;

public class Query {
    private Connection db = ConnectDB.dbConnect();
    private PreparedStatement stmt;
    private ResultSet rs;

    //Printing all Customers
    public void getAllCustomers(){
        try {
            String sql = "select * from customers";
            setStmt(getDb().prepareStatement(sql));
            setRs(getStmt().executeQuery());

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

    //Search for customers by their names
    public void showSimilarCustomers(String name){
        try{
            setStmt(getDb().prepareStatement(
                    "select contact_name from customers where contact_name like ?"));
            getStmt().clearParameters();
            getStmt().setString(1, name + "%");
            setRs(getStmt().executeQuery());

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

    //Search for product category
    public void showProductCategory(){
        try{
            setStmt(getDb().prepareStatement("select * from categories"));
            setRs(getStmt().executeQuery());

            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %70s", "ID", "CATEGORY NAME", "DESCRIPTION");
            System.out.println("\n------------------------------------------------------------------------------------------------------------");
            while (getRs().next()){
                System.out.format("%5s %20s %70s",
                        getRs().getInt("category_id"),
                        getRs().getString("category_name"),
                        getRs().getString("description")
                );
                System.out.println();
            }
            System.out.println("\n------------------------------------------------------------------------------------------------------------");
            getStmt().close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Search for product category
    public void showProducts(){
        try{
            setStmt(getDb().prepareStatement("select * from products"));
            setRs(getStmt().executeQuery());

            System.out.println("------------------------------------------------------------------------------------------------------------");

            System.out.println("\n------------------------------------------------------------------------------------------------------------");
            while (getRs().next()){
                System.out.format("%5s %20s %70s",
                        getRs().getInt("category_id"),
                        getRs().getString("category_name"),
                        getRs().getString("description")
                );
                System.out.println();
            }
            System.out.println("\n------------------------------------------------------------------------------------------------------------");
            getStmt().close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void setDb(Connection db) {
        this.db = db;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Connection getDb() {
        return db;
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public ResultSet getRs() {
        return rs;
    }
}
