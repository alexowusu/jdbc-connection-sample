package io.turntabl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class JDBCMain {
    public static void main(String[] args){
        ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml");
        JdbcTemplate tmpl = (JDBCTemplate) ctx.getBean("jdbcTemplate");

        int numRow = tmpl.queryForObject("select count(customer) from customers", Integer.class);
        System.out.println(numRow);

        String nme =(String)tmpl.queryForObject("select contact_name from customers where contact_name like =?",String.class);
        System.out.println(nme);

        //System.out.println(ConnectDB.dbConnect());

//        Query cus = new Query();
//        cus.getAllCustomers();
//
//        //Showing Product Categories
//        Query prod = new Query();
//        prod.showProductCategory();
//
//
//        //Searching for customer
//        Query search = new Query();
//        System.out.println("SEARCH FOR CUSTOMERS\nEnter Customer Name: ");
//        Scanner sc = new Scanner(System.in);
//        String name = sc.nextLine();
//        if(name.isEmpty() || name.contains(",")){
//            System.out.println("Please Enter a Valid Name: ");
//        }else {
//            search.showSimilarCustomers(name);
//        }


        ProductDAOI product = new ProductDAOI();
        product.getProductsByCustomer("John Steel");

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.sql.Date d1 = (java.sql.Date) f.parse("1997-07-10");
            Date d2 = f.parse("1997-07-10");

            product.getProductSalesForAGivenWeek(d1, (java.sql.Date) d2);

        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

}
