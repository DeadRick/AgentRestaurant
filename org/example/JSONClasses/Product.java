// Product.java

package org.example.JSONClasses;

import java.time.OffsetDateTime;

public class Product {
    private Long productProdItemID;
    private Long prodItemType;
    private String prodItemName;
    private String prodItemCompany;
    private String prodItemUnit;
    private double prodItemQuantity;
    private double prodItemCost;
    private OffsetDateTime prodItemDelivered;
    private OffsetDateTime prodItemValidUntil;
    private Long productProdItemType;
    private Long prodItemID;

    public Long getProductProdItemID() { return productProdItemID; }
    public void setProductProdItemID(Long value) { this.productProdItemID = value; }

    public Long getProdItemType() { return prodItemType; }
    public void setProdItemType(Long value) { this.prodItemType = value; }

    public String getProdItemName() { return prodItemName; }
    public void setProdItemName(String value) { this.prodItemName = value; }

    public String getProdItemCompany() { return prodItemCompany; }
    public void setProdItemCompany(String value) { this.prodItemCompany = value; }

    public String getProdItemUnit() { return prodItemUnit; }
    public void setProdItemUnit(String value) { this.prodItemUnit = value; }

    public double getProdItemQuantity() { return prodItemQuantity; }
    public void setProdItemQuantity(double value) { this.prodItemQuantity = value; }

    public double getProdItemCost() { return prodItemCost; }
    public void setProdItemCost(double value) { this.prodItemCost = value; }

    public OffsetDateTime getProdItemDelivered() { return prodItemDelivered; }
    public void setProdItemDelivered(OffsetDateTime value) { this.prodItemDelivered = value; }

    public OffsetDateTime getProdItemValidUntil() { return prodItemValidUntil; }
    public void setProdItemValidUntil(OffsetDateTime value) { this.prodItemValidUntil = value; }

    public Long getProductProdItemType() { return productProdItemType; }
    public void setProductProdItemType(Long value) { this.productProdItemType = value; }

    public Long getProdItemID() { return prodItemID; }
    public void setProdItemID(Long value) { this.prodItemID = value; }
}
