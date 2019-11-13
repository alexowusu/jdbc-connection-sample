package io.turntabl;

import java.sql.Date;
import java.sql.SQLException;

public interface ProductDAO {
    public void getProductsByCustomer(String name);

    public void getFiveMostPopularProducts();

    public void getProductSalesForAGivenWeek(Date date1, Date date2);
}
