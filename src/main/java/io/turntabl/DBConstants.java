package io.turntabl;

public class DBConstants {
    public static String PRODUCTS_BY_CUSTOMER = "select product_name, order_details.unit_price from products " +
            "inner join order_details on products.product_id = order_details.product_id " +
            "inner join orders on order_details.order_id = orders.order_id " +
            "inner join customers on orders.customer_id = customers.customer_id " +
            "where customers.contact_name like ? ";

    public static String MOST_POPULAR_PRODUCTS = "";

    public static String PRODUCT_SALES_FOR_A_GIVEN_WEEK = "select product_name, shipped_date, customers.contact_name from products " +
            "inner join order_details on products.product_id = order_details.product_id " +
            "inner join orders on order_details.order_id = orders.order_id " +
            "inner join customers on orders.customer_id = customers.customer_id " +
            "where orders.shipped_date between ? and ?";
}
