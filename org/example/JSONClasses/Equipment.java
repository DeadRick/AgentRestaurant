// Equipment.java

package org.example.JSONClasses;

public class Equipment {
    private long equip_id;
    private long equip_type;
    private String equip_name;
    private boolean equip_active;

    public long getEquip_id() { return equip_id; }
    public void setEquip_id(long value) { this.equip_id = value; }

    public long getEquip_type() { return equip_type; }
    public void setEquip_type(long value) { this.equip_type = value; }

    public String getEquip_name() { return equip_name; }
    public void setEquip_name(String value) { this.equip_name = value; }

    public boolean getEquip_active() { return equip_active; }
    public void setEquip_active(boolean value) { this.equip_active = value; }
}
