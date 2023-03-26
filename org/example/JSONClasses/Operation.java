// Operation.java

package org.example.JSONClasses;

public class Operation {
    private long oper_type;
    private long equip_type;
    private double oper_time;
    private long oper_async_point;
    private OperProduct[] oper_products;

    public long getOper_type() { return oper_type; }
    public void setOper_type(long value) { this.oper_type = value; }

    public long getEquip_type() { return equip_type; }
    public void setEquip_type(long value) { this.equip_type = value; }

    public double getOper_time() { return oper_time; }
    public void setOper_time(double value) { this.oper_time = value; }

    public long getOper_async_point() { return oper_async_point; }
    public void setOper_async_point(long value) { this.oper_async_point = value; }

    public OperProduct[] getOper_products() { return oper_products; }
    public void setOper_products(OperProduct[] value) { this.oper_products = value; }
}