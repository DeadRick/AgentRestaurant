package org.example;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

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
        System.out.println("{---OrderAgent---}\n ID: " + getAID().getName() + "\n{---------}\n");
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("order-agent-work");
        sd.setName("order-agent");
        dfd.addServices(sd);

        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            e.printStackTrace();
        }

        addBehaviour(new GetOrderBehaviour());
    }

    private static class GetOrderBehaviour extends CyclicBehaviour {

        @Override
        public void action() {
            // Создаем шаблон сообщения на
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = myAgent.receive(mt);
            if (msg != null) {
                String order = msg.getContent();
                System.out.println("[---MESSAGE---]\n From: " +
                        msg.getSender().getLocalName() + "\n To: " +
                        myAgent.getLocalName() + "\n Message: " +
                        order + "\n[------]\n");
            } else {
                block();
            }
        }
    }
}
