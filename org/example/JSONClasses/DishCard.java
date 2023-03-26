// DishCard.java

package org.example.JSONClasses;

public class DishCard {
    private long card_id;
    private String dish_name;
    private String card_descr;
    private double card_time;
    private long equip_type;
    private Operation[] operations;

    public long getCard_id() { return card_id; }
    public void setCard_id(long value) { this.card_id = value; }

    public String getDish_name() { return dish_name; }
    public void setDish_name(String value) { this.dish_name = value; }

    public String getCard_descr() { return card_descr; }
    public void setCard_descr(String value) { this.card_descr = value; }

    public double getCard_time() { return card_time; }
    public void setCard_time(double value) { this.card_time = value; }

    public long getEquip_type() { return equip_type; }
    public void setEquip_type(long value) { this.equip_type = value; }

    public Operation[] getOperations() { return operations; }
    public void setOperations(Operation[] value) { this.operations = value; }
}