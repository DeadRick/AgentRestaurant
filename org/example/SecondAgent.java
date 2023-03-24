package org.example;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

public class SecondAgent extends Agent{
    // Запрос на покупку.
    private String targetBuyer;

    protected void setup() {

        // Выводим в консоль имя агента.
        System.out.println("Hello! " + getAID().getName() + " is here!");


        // Получаем аргументы из консоли.
        // Аргументы задаются путём передачи через параметры.
        // Пример: FirstAgent:org.example.FirstAgent(MyBook)

        Object[] args = getArguments();
        if (args != null && args.length > 0) {
            targetBuyer = (String) args[0];
            System.out.println(getAID().getName() + "trying to buy " + targetBuyer);

            // Поведение агента. В нашем случае, WakerBehaviour выполняется единожды.
            // Также есть TickerBehavior, он цикличен и выполняется раз в N тиков (задается в парметрах).
            addBehaviour(new WakerBehaviour(this, 10000) {
                @Override
                protected void onWake() {
                    super.onWake();
                    System.out.println(getAID().getName() + " give a book to a client!");
                    doDelete();
                }
            });
        }
        else {
            System.out.println("No book title specified");
            doDelete();
        }
    }

    protected void takeDown() {
        if (targetBuyer != null && targetBuyer.length() > 0) {
            System.out.println("Buyer-agent " + getAID().getName() + " died, he bought " + targetBuyer + " book.");
        } else {
            System.out.println("Buyer-agent " + getAID().getName() + " terminating.");
        }
    }
}
