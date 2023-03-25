// Equipment.java

package org.example.JSONClasses;

public class Equipment {
    private long equipID;
    private long equipType;
    private String equipName;
    private boolean equipActive;

    public long getEquipID() { return equipID; }
    public void setEquipID(long value) { this.equipID = value; }

    public long getEquipType() { return equipType; }
    public void setEquipType(long value) { this.equipType = value; }

    public String getEquipName() { return equipName; }
    public void setEquipName(String value) { this.equipName = value; }

    public boolean getEquipActive() { return equipActive; }
    public void setEquipActive(boolean value) { this.equipActive = value; }
}
