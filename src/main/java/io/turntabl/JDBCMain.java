package io.turntabl;

import java.util.Scanner;

public class JDBCMain {
    public static void main(String[] args){
        System.out.println(ConnectDB.dbConnect());

        Query cus = new Query();
        cus.getAllCustomers();

        //Showing Product Categories
        Query prod = new Query();
        prod.showProductCategory();


        //Searching for customer
        Query search = new Query();
        System.out.println("SEARCH FOR CUSTOMERS\nEnter Customer Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if(name.isEmpty() || name.contains(",")){
            System.out.println("Please Enter a Valid Name: ");
        }else {
            search.showSimilarCustomers(name);
        }

//        ProductDAOI product = new ProductDAOI();
//        product.getProductsByCustomer("John Steel");

    }

}
