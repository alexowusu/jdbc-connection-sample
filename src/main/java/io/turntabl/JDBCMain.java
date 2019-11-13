package io.turntabl;

import java.util.Scanner;

public class JDBCMain {
    public static void main(String[] args){
        System.out.println(ConnectDB.dbConnect());

        Query cus = new Query();
        cus.getAllCustomers();

        Query search = new Query();

        System.out.println("SEARCH FOR CUSTOMERS\nEnter Customer Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if(name.isEmpty() || name.contains(",")){
            System.out.println("Please Enter a Valid Name: ");
        }else {
            search.showSimilarCustomers(name);
        }

    }

}
