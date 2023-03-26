package org.example;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import org.example.JSONClasses.OrderDish;

import java.util.List;

public class VisitorAgent extends Agent {


    // Список агентов-продавцов. Пока что непонятно зачем.
    private AID supervisor;

    private String visitorName;
    private String visitorOrdStarted;
    private String visitorOrdEnded;
    private int visitorOrdTotal;
    private List<OrderDish> visitorOrdDishes;

    // Чтение и запись аргументов, переданные агенту.
    public void setParameters() {
        Object[] arg = getArguments();
        if (arg != null && arg.length == 5) {
            visitorName = arg[0].toString();
            visitorOrdStarted = arg[1].toString();
            visitorOrdEnded = arg[2].toString();
            visitorOrdTotal = (int) arg[3];
            visitorOrdDishes = (List<OrderDish>) arg[4];
            System.out.println("|---" + visitorName + "---|\n Welcome!" + "\n Start time: "
                    + visitorOrdStarted + " \n End time: " + visitorOrdEnded
                    + " \n Ord total: - " + visitorOrdTotal + "\n|------|\n");
        }
    }

    // Инициализация агента.
    protected void setup() {

        // Получение параметров.
        setParameters();

        // Поиск супервайзора.
        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("supervisor-work");
        template.addServices(sd);
        // Прикрепляем к постетителю супервизора.
        try {
            DFAgentDescription[] result = DFService.search(this, template);
            supervisor = new AID();
            supervisor = result[0].getName();
            System.out.println("Visitor found his supervisor " + result[0].getName().getLocalName());

            // Отправляем заказы нашему супервизору.
            for (int i = 0; i < visitorOrdDishes.size(); i++) {
                addBehaviour(new OrderRequest(visitorOrdDishes.get(i).getOrd_dish_id(), visitorOrdDishes.get(i).getMenu_dish()));
            }
        } catch (FIPAException e) {
            e.printStackTrace(); // #TODO Log4j
        }
    }

    // Убийство агента.
    protected void takeDown() {
        System.out.println("Buyer-agent " + getAID().getName() + " left the restaurant.");
    }

    private class OrderRequest extends Behaviour {
        private Integer step = 0;
        private MessageTemplate mt;
        private String order;

        public OrderRequest(Long ord_dish_id, Long menu_dish) {
            order = ord_dish_id.toString() + ";" + menu_dish.toString();
        }

        @Override
        public void action() {
            switch (step) {
                case 0:
                    ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
                    cfp.addReceiver(supervisor);
                    cfp.setContent(order);
                    cfp.setConversationId("make-order");
                    cfp.setReplyWith("cfp" + System.currentTimeMillis());
                    myAgent.send(cfp);
                    mt = MessageTemplate.and(MessageTemplate.MatchConversationId("make-order"), // Я эту ошибку фиксил час...
                            MessageTemplate.MatchInReplyTo(cfp.getReplyWith()));                     // Оказывается, тут нужно точь-в-точь ID вводить. :(
                    step++;
                    break;
                case 1:
                    ACLMessage reply = myAgent.receive(mt);
                    if (reply != null) {
                        if (reply.getPerformative() == ACLMessage.PROPOSE) {
                            String isReady = reply.getContent();
                            System.out.println("\n[---MESSAGE---]\n From: " + reply.getSender().getLocalName() +
                                    "\n Message: " + reply.getContent() + "\n[------]\n");
                        }
                    } else {
                        block();
                    }
                    break;
            }

        }

        @Override
        public boolean done() {
            return step == 2;
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}
