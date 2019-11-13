package io.turntabl;

public class ProductTO {
    private String product_name;
    private Integer supplier_id;
    private Integer category_id;

    public ProductTO(String product_name, Integer supplier_id, Integer category_id) {
        this.product_name = product_name;
        this.supplier_id = supplier_id;
        this.category_id = category_id;
    }


}
