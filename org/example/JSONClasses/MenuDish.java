// MenuDish.java

package org.example.JSONClasses;

public class MenuDish {
    private long menu_dish_id;
    private long menu_dish_card;
    private long menu_dish_price;
    private boolean menu_dish_active;

    public long getMenu_dish_id() { return menu_dish_id; }
    public void setMenu_dish_id(long value) { this.menu_dish_id = value; }

    public long getMenu_dish_card() { return menu_dish_card; }
    public void setMenu_dish_card(long value) { this.menu_dish_card = value; }

    public long getMenu_dish_price() { return menu_dish_price; }
    public void setMenu_dish_price(long value) { this.menu_dish_price = value; }

    public boolean getMenu_dish_active() { return menu_dish_active; }
    public void setMenu_dish_active(boolean value) { this.menu_dish_active = value; }
}
