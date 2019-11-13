package io.turntabl;

import java.sql.*;
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
    public void getProductSalesForAGivenWeek() {

    }
}
