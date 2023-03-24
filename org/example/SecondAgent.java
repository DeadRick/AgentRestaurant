package org.example;

import jade.core.AID;
import jade.core.Agent;

public class SecondAgent extends Agent{
    // Запрос на покупку.
    private String targetBuyer;

    // Список агентов-продавцов.
    private AID[] sellerAgents = {new AID("Seller1", AID.ISLOCALNAME),
            new AID("Seller2", AID.ISLOCALNAME)};

    protected void setup() {
        // Выводим в консоль имя агента.
        System.out.println("Hello! " + getAID().getName() + " is here!");

        // Получаем аргументы из консоли.
        // Аргументы задаются путём передачи через параметры.
        // Пример: FirstAgent:org.example.FirstAgent(MyBook)s
        Object[] args = getArguments();
        if (args != null && args.length > 0) {
            targetBuyer = (String) args[0];
            System.out.println(getAID().getName() + "trying to buy " + targetBuyer);
        }
        else {
            System.out.println("No book title specified");
            doDelete();
        }
    }

    protected void takeDown() {
        if (targetBuyer != null && targetBuyer.length() > 0) {
            System.out.println("Buyer-agent " + getAID().getName() + " died, he bought " + targetBuyer + "book.");
        } else {
            System.out.println("Buyer-agent " + getAID().getName() + " terminating.");
        }
    }
}
