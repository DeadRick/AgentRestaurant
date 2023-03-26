// Product.java

package org.example.JSONClasses;

import java.time.OffsetDateTime;

public class Product {
    private Long product_prod_item_id;
    private Long prod_item_type;
    private String prod_item_name;
    private String prod_item_company;
    private String prod_item_unit;
    private double prod_item_quantity;
    private double prod_item_cost;
    private OffsetDateTime prod_item_delivered;
    private OffsetDateTime prod_item_valid_until;
    private Long product_prod_item_type;
    private Long prod_item_id;

    public Long getProduct_prod_item_id() { return product_prod_item_id; }
    public void setProduct_prod_item_id(Long value) { this.product_prod_item_id = value; }

    public Long getProd_item_type() { return prod_item_type; }
    public void setProd_item_type(Long value) { this.prod_item_type = value; }

    public String getProd_item_name() { return prod_item_name; }
    public void setProd_item_name(String value) { this.prod_item_name = value; }

    public String getProd_item_company() { return prod_item_company; }
    public void setProd_item_company(String value) { this.prod_item_company = value; }

    public String getProd_item_unit() { return prod_item_unit; }
    public void setProd_item_unit(String value) { this.prod_item_unit = value; }

    public double getProdItemQuantity() { return prod_item_quantity; }
    public void setProdItemQuantity(double value) { this.prod_item_quantity = value; }

    public double getProd_item_cost() { return prod_item_cost; }
    public void setProd_item_cost(double value) { this.prod_item_cost = value; }

    public OffsetDateTime getProd_item_delivered() { return prod_item_delivered; }
    public void setProd_item_delivered(OffsetDateTime value) { this.prod_item_delivered = value; }

    public OffsetDateTime getProd_item_valid_until() { return prod_item_valid_until; }
    public void setProd_item_valid_until(OffsetDateTime value) { this.prod_item_valid_until = value; }

    public Long getProduct_prod_item_type() { return product_prod_item_type; }
    public void setProduct_prod_item_type(Long value) { this.product_prod_item_type = value; }

    public Long getProd_item_id() { return prod_item_id; }
    public void setProd_item_id(Long value) { this.prod_item_id = value; }
}
