package org.example;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

public class FirstAgent extends Agent {
    // Запрос на покупку.
    private String targetBuyer;

    // Список агентов-продавцов.
    private AID[] sellerAgents = {new AID("SecondAgent", AID.ISLOCALNAME),
            new AID("Seller2", AID.ISLOCALNAME)};

    // Инициализация агента.
    protected void setup() {
        // Выводим в консоль имя агента.
        System.out.println("Hello! " + getAID().getName() + " is here!");

        // Пробуем отправить сообщение.
        //
        ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
        for (int i = 0; i < sellerAgents.length; ++i) {
            cfp.addReceiver(sellerAgents[i]);
        }

        cfp.setContent(targetBuyer);
        send(cfp);
        // Получаем аргументы из консоли.
        // Аргументы задаются путём передачи через параметры.
        // Пример: FirstAgent:org.example.FirstAgent(MyBook)s
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

}
