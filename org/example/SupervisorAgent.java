package org.example;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.util.leap.Map;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class SupervisorAgent extends Agent {
    // Запрос на покупку.
    private String targetBuyer;
    private HashMap<AID, List<String>> orderList;
    static AID orderAgent;

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

    private void callOrderAgent() throws StaleProxyException {
        AgentContainer container = getContainerController();
        AgentController order_agent = container.createNewAgent("Order Agent", "org.example.OrderAgent", null);
        order_agent.start();
    }

    protected void setup() {
        orderList = new HashMap<>();
        // Выводим в консоль имя агента.
        System.out.println("<---" + getAID().getLocalName() + "--->\n" +
                "ID: " + getAID().getName() + "\n<------>\n");
        try {
            callOrderAgent();
        } catch (StaleProxyException e) {
            throw new RuntimeException(e);
        }
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("supervisor-work");
        sd.setName("supervisor");
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
            DFAgentDescription template = new DFAgentDescription();
            ServiceDescription serviceDescription = new ServiceDescription();
            serviceDescription.setType("order-agent-work");
            template.addServices(serviceDescription);
            try {
                DFAgentDescription[] result = DFService.search(this, template);
                orderAgent = new AID();
                orderAgent = result[0].getName();
                System.out.println("Supervisor got his order agent.");
            } catch (FIPAException e) {
                throw new RuntimeException(e);
            }
        } catch (FIPAException e) {
            e.printStackTrace(); // #TODO Log4j
        }
        addBehaviour(new DishOrdersServer());
    }

    protected void takeDown() {
        System.out.println("Supervisor " + getAID().getName() + " died.");
    }
    private static class DishOrdersServer extends CyclicBehaviour {
        @Override
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = myAgent.receive(mt);
            if (msg != null) {
                String order = msg.getContent();
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.PROPOSE);
                reply.setContent("Your order is being processed!\n" +
                        "I sent this message to " + msg.getSender().getLocalName() + ".");
                System.out.println("!--- ORDER ---!\n" +
                        " From: " + msg.getSender().getLocalName() + "\n" +
                        " Order: " + order + "\n!-------------!\n");
                myAgent.send(reply);

                // Отправляем заказ OrderAgent'у
                ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
                cfp.addReceiver(orderAgent);
                cfp.setContent(order);
                cfp.setConversationId("send-order");
                cfp.setReplyWith("cfp" + System.currentTimeMillis());
                myAgent.send(cfp);
            } else {
                block();
            }
        }
    }
}




