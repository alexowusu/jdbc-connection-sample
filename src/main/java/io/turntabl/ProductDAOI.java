package io.turntabl;

import java.sql.*;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAOI implements ProductDAO {
    Connection conn = ConnectDB.dbConnect();

    @Override
    public void getProductsByCustomer(String name) {
        try {
            PreparedStatement ps = conn.prepareStatement(DBConstants.PRODUCTS_BY_CUSTOMER);
            ps.clearParameters();
            ps.setString(1, name + "%");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("product_name"));
                System.out.println(rs.getString("unit_price"));
                System.out.println("-----------------------");
            }
        }catch (Exception ex){
                    Logger.getLogger(ProductDAOI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void getFiveMostPopularProducts() {

    }

    @Override
    public void getProductSalesForAGivenWeek(Date date1, Date date2) {
                try {
            PreparedStatement ps = conn.prepareStatement(DBConstants.PRODUCT_SALES_FOR_A_GIVEN_WEEK);
            ps.clearParameters();
            ps.setDate(1, date1);
            ps.setDate(2, date2);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("product_name"));
                System.out.println(rs.getDate("shipped_date"));
                System.out.println(rs.getString("customers.contact_name"));

                System.out.println("-----------------------");
            }
        }catch (Exception ex){
            Logger.getLogger(ProductDAOI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    @Override
//    public void getProductSalesForAGivenWeek(Date date1, Date date2) {
//        try {
//            PreparedStatement ps = conn.prepareStatement(DBConstants.PRODUCT_SALES_FOR_A_GIVEN_WEEK);
//            ps.clearParameters();
//            ps.setDate(1, date1);
//            ps.setDate(2, date2);
//
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                System.out.println(rs.getString("product_name"));
//                System.out.println(rs.getDate("shipped_date"));
//                System.out.println(rs.getString("customers.contact_name"));
//
//                System.out.println("-----------------------");
//            }
//        }catch (Exception ex){
//            Logger.getLogger(ProductDAOI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
