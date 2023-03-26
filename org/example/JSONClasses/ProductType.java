// ProductType.java

package org.example.JSONClasses;

public class ProductType {
    private long prod_type_id;
    private String prod_type_name;
    private boolean prod_is_food;

    public long getProd_type_id() { return prod_type_id; }
    public void setProd_type_id(long value) { this.prod_type_id = value; }

    public String getProd_type_name() { return prod_type_name; }
    public void setProd_type_name(String value) { this.prod_type_name = value; }

    public boolean getProd_is_food() { return prod_is_food; }
    public void setProd_is_food(boolean value) { this.prod_is_food = value; }
}
