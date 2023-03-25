// VisitorsOrder.java

package org.example.JSONClasses;

import java.time.OffsetDateTime;

public class VisitorsOrder {
    private String visName;
    private OffsetDateTime visOrdStarted;
    private OffsetDateTime visOrdEnded;
    private long visOrdTotal;
    private VisOrdDish[] visOrdDishes;

    public String getVisName() { return visName; }
    public void setVisName(String value) { this.visName = value; }

    public OffsetDateTime getVisOrdStarted() { return visOrdStarted; }
    public void setVisOrdStarted(OffsetDateTime value) { this.visOrdStarted = value; }

    public OffsetDateTime getVisOrdEnded() { return visOrdEnded; }
    public void setVisOrdEnded(OffsetDateTime value) { this.visOrdEnded = value; }

    public long getVisOrdTotal() { return visOrdTotal; }
    public void setVisOrdTotal(long value) { this.visOrdTotal = value; }

    public VisOrdDish[] getVisOrdDishes() { return visOrdDishes; }
    public void setVisOrdDishes(VisOrdDish[] value) { this.visOrdDishes = value; }
}