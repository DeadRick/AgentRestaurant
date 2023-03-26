// ProcessLog.java

package org.example.JSONClasses;

import java.time.OffsetDateTime;

public class ProcessLog {
    private long proc_id;
    private long ord_dish;
    private OffsetDateTime proc_started;
    private OffsetDateTime proc_ended;
    private boolean proc_active;
    private ProcOperation[] proc_operations;

    public long getProc_id() { return proc_id; }
    public void setProc_id(long value) { this.proc_id = value; }

    public long getOrd_dish() { return ord_dish; }
    public void setOrd_dish(long value) { this.ord_dish = value; }

    public OffsetDateTime getProc_started() { return proc_started; }
    public void setProc_started(OffsetDateTime value) { this.proc_started = value; }

    public OffsetDateTime getProc_ended() { return proc_ended; }
    public void setProc_ended(OffsetDateTime value) { this.proc_ended = value; }

    public boolean getProc_active() { return proc_active; }
    public void setProc_active(boolean value) { this.proc_active = value; }

    public ProcOperation[] getProc_operations() { return proc_operations; }
    public void setProc_operations(ProcOperation[] value) { this.proc_operations = value; }
}
