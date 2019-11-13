package io.turntabl;

import java.sql.SQLException;

public interface ProductDAO {
    public void getProductsByCustomer(String name);

    public void getFiveMostPopularProducts();

    public void getProductSalesForAGivenWeek();
}
