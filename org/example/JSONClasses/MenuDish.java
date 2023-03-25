// MenuDish.java

package org.example.JSONClasses;

public class MenuDish {
    private long menuDishID;
    private long menuDishCard;
    private long menuDishPrice;
    private boolean menuDishActive;

    public long getMenuDishID() { return menuDishID; }
    public void setMenuDishID(long value) { this.menuDishID = value; }

    public long getMenuDishCard() { return menuDishCard; }
    public void setMenuDishCard(long value) { this.menuDishCard = value; }

    public long getMenuDishPrice() { return menuDishPrice; }
    public void setMenuDishPrice(long value) { this.menuDishPrice = value; }

    public boolean getMenuDishActive() { return menuDishActive; }
    public void setMenuDishActive(boolean value) { this.menuDishActive = value; }
}
