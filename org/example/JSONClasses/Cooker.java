// Cooker.java

package org.example.JSONClasses;

public class Cooker {
    private long cook_id;
    private String cook_name;
    private boolean cook_active;

    public long getCook_id() { return cook_id; }
    public void setCook_id(long value) { this.cook_id = value; }

    public String getCook_name() { return cook_name; }
    public void setCook_name(String value) { this.cook_name = value; }

    public boolean getCook_active() { return cook_active; }
    public void setCook_active(boolean value) { this.cook_active = value; }
}
