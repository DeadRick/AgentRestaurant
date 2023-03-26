// VisitorsOrder.java

package org.example.JSONClasses;

import java.time.OffsetDateTime;
import java.util.List;

public class VisitorOrder {
    private String vis_name;
    private String vis_ord_started;
    private String vis_ord_ended;
    private int vis_ord_total;
    private List<OrderDish> vis_ord_dishes;

    // add getters and setters here

    public String getVis_name() {
        return vis_name;
    }

    public void setVis_name(String vis_name) {
        this.vis_name = vis_name;
    }

    public String getVis_ord_started() {
        return vis_ord_started;
    }

    public void setVis_ord_started(String vis_ord_started) {
        this.vis_ord_started = vis_ord_started;
    }

    public String getVis_ord_ended() {
        return vis_ord_ended;
    }

    public void setVis_ord_ended(String vis_ord_ended) {
        this.vis_ord_ended = vis_ord_ended;
    }

    public int getVis_ord_total() {
        return vis_ord_total;
    }

    public void setVis_ord_total(int vis_ord_total) {
        this.vis_ord_total = vis_ord_total;
    }

    public List<OrderDish> getVis_ord_dishes() {
        return vis_ord_dishes;
    }

    public void setVis_ord_dishes(List<OrderDish> vis_ord_dishes) {
        this.vis_ord_dishes = vis_ord_dishes;
    }
}