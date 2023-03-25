// ProductType.java

package org.example.JSONClasses;

public class ProductType {
    private long prodTypeID;
    private String prodTypeName;
    private boolean prodIsFood;

    public long getProdTypeID() { return prodTypeID; }
    public void setProdTypeID(long value) { this.prodTypeID = value; }

    public String getProdTypeName() { return prodTypeName; }
    public void setProdTypeName(String value) { this.prodTypeName = value; }

    public boolean getProdIsFood() { return prodIsFood; }
    public void setProdIsFood(boolean value) { this.prodIsFood = value; }
}
