// ProcessLog.java

package org.example.JSONClasses;

import java.time.OffsetDateTime;

public class ProcessLog {
    private long procID;
    private long ordDish;
    private OffsetDateTime procStarted;
    private OffsetDateTime procEnded;
    private boolean procActive;
    private ProcOperation[] procOperations;

    public long getProcID() { return procID; }
    public void setProcID(long value) { this.procID = value; }

    public long getOrdDish() { return ordDish; }
    public void setOrdDish(long value) { this.ordDish = value; }

    public OffsetDateTime getProcStarted() { return procStarted; }
    public void setProcStarted(OffsetDateTime value) { this.procStarted = value; }

    public OffsetDateTime getProcEnded() { return procEnded; }
    public void setProcEnded(OffsetDateTime value) { this.procEnded = value; }

    public boolean getProcActive() { return procActive; }
    public void setProcActive(boolean value) { this.procActive = value; }

    public ProcOperation[] getProcOperations() { return procOperations; }
    public void setProcOperations(ProcOperation[] value) { this.procOperations = value; }
}
