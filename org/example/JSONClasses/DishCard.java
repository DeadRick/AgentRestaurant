// DishCard.java

package org.example.JSONClasses;

public class DishCard {
    private long cardID;
    private String dishName;
    private String cardDescr;
    private double cardTime;
    private long equipType;
    private Operation[] operations;

    public long getCardID() { return cardID; }
    public void setCardID(long value) { this.cardID = value; }

    public String getDishName() { return dishName; }
    public void setDishName(String value) { this.dishName = value; }

    public String getCardDescr() { return cardDescr; }
    public void setCardDescr(String value) { this.cardDescr = value; }

    public double getCardTime() { return cardTime; }
    public void setCardTime(double value) { this.cardTime = value; }

    public long getEquipType() { return equipType; }
    public void setEquipType(long value) { this.equipType = value; }

    public Operation[] getOperations() { return operations; }
    public void setOperations(Operation[] value) { this.operations = value; }
}