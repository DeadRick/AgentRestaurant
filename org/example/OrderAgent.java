package org.example;

import jade.core.AID;
import jade.core.Agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderAgent extends Agent {
    private HashMap<AID, List<String>> orderList;

    private void updateOrderList(AID aid, String orderId) {
        List<String> tempList = new ArrayList<>();
        if (orderList.containsKey(aid)) {
            tempList = orderList.get(aid);
            tempList.add(orderId);
            orderList.put(aid, tempList);
        } else {
            tempList.add(orderId);
            orderList.put(aid, tempList);
        }
    }
    protected void setup() {

    }
}
