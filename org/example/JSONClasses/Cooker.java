// Cooker.java

package org.example.JSONClasses;

public class Cooker {
    private long cookID;
    private String cookName;
    private boolean cookActive;

    public long getCookID() { return cookID; }
    public void setCookID(long value) { this.cookID = value; }

    public String getCookName() { return cookName; }
    public void setCookName(String value) { this.cookName = value; }

    public boolean getCookActive() { return cookActive; }
    public void setCookActive(boolean value) { this.cookActive = value; }
}
