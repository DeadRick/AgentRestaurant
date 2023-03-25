package org.example;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class VisitorAgent extends Agent {
    // Запрос на покупку.
    private String targetBuyer;

    // Список агентов-продавцов. Пока что непонятно зачем.
    private AID supervisor;


    // Инициализация агента.
    protected void setup() {
        // Выводим в консоль имя агента.
        System.out.println("Hello! " + getAID().getName() + " is here!");

        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();

        sd.setType("supervisor-work");
        template.addServices(sd);

        // Прикрепляем к постетителю супервизора.
        try {
            DFAgentDescription[] result = DFService.search(this, template);
            supervisor = new AID();
            supervisor = result[0].getName();
            System.out.println("Visitor found his supervisor " + result[0].getName());
        } catch (FIPAException e) {
            e.printStackTrace(); // #TODO Log4j
        }
        // Получаем аргументы из консоли.
        // Аргументы задаются путём передачи через параметры.
        // Пример: VisitorAgent:org.example.VisitorAgent(MyBook)s
        Object[] args = getArguments();
        if (args != null && args.length > 0) {
            targetBuyer = (String) args[0];
            System.out.println("Trying to buy " + targetBuyer);
//            addBehaviour(new RequestPerfomer());
        } else {
            System.out.println("No book title specified");
            doDelete();
        }
    }

    // Убийство агента.
    protected void takeDown() {
        if (targetBuyer != null && targetBuyer.length() > 0) {
            System.out.println("Buyer-agent " + getAID().getName() + " died. The target " + targetBuyer + " was succesfully done.");
        } else {
            System.out.println("Buyer-agent " + getAID().getName() + " terminating.");
        }
    }

    private class OrderRequest extends Behaviour {
        private Integer step = 0;
        private AID supervisorID;
        private MessageTemplate mt;

        @Override
        public void action() {
            switch (step) {
                case 0:
                    ACLMessage cfp = new ACLMessage(ACLMessage.CFP);

            }
        }

        @Override
        public boolean done() {
            return false;
        }
    }
}
