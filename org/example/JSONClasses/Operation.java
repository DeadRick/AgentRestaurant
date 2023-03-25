// Operation.java

package org.example.JSONClasses;

public class Operation {
    private long operType;
    private long equipType;
    private double operTime;
    private long operAsyncPoint;
    private OperProduct[] operProducts;

    public long getOperType() { return operType; }
    public void setOperType(long value) { this.operType = value; }

    public long getEquipType() { return equipType; }
    public void setEquipType(long value) { this.equipType = value; }

    public double getOperTime() { return operTime; }
    public void setOperTime(double value) { this.operTime = value; }

    public long getOperAsyncPoint() { return operAsyncPoint; }
    public void setOperAsyncPoint(long value) { this.operAsyncPoint = value; }

    public OperProduct[] getOperProducts() { return operProducts; }
    public void setOperProducts(OperProduct[] value) { this.operProducts = value; }
}