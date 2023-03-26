package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import org.example.JSONClasses.VisitorOrder;
import org.example.JSONClasses.VisitorsGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class SupervisorAgent extends Agent {
    // Запрос на покупку.
    private String targetBuyer;


    // "src/main/resources/visitors.json"
    protected void generateVisitors() throws IOException {
        // Create an instance of ObjectMapper, which is used to read JSON data
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON data from a file
        File file = new File("src/main/resources/visitors.json");
        VisitorOrder[] visitorOrders = objectMapper.readValue(file, VisitorOrder[].class);

        // Print the data
        for (VisitorOrder visitorOrder : visitorOrders) {
            System.out.println("Visitor name: " + visitorOrder.getVis_name());
            System.out.println();
        }
    }

    protected void setup() {

        // Выводим в консоль имя агента.
        System.out.println("Hello! " + getAID().getName() + " is here!");
//        try {
//            generateVisitors();
//        } catch (IOException e) {
//            System.out.println("Failed to read JSON-file."); // #TODO: Log4J
//        }

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("supervisor-work");
        sd.setName("supervisor");
        dfd.addServices(sd);

        try {
            DFService.register(this, dfd);
            generateVisitors();
            AgentContainer container = getContainerController();
            AgentController newAgent = container.createNewAgent("Visitor", "org.example.VisitorAgent", null);
            newAgent.start();

        } catch (FIPAException e) {
            e.printStackTrace(); // #TODO Log4j
        } catch (StaleProxyException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Получаем аргументы из консоли.
        // Аргументы задаются путём передачи через параметры.
        // Пример: VisitorAgent:org.example.VisitorAgent(MyBook)
//        Object[] args = getArguments();
//        if (args != null && args.length > 0) {
//            targetBuyer = (String) args[0];
//            System.out.println(getAID().getName() + "trying to buy " + targetBuyer);
//
//            // Поведение агента. В нашем случае, WakerBehaviour выполняется единожды.
//            // Также есть TickerBehavior, он цикличен и выполняется раз в N тиков (задается в парметрах).
//            addBehaviour(new WakerBehaviour(this, 10000) {
//                @Override
//                protected void onWake() {
//                    super.onWake();
//                    System.out.println(getAID().getName() + " give a book to a client!");
//                    doDelete();
//                }
//            });
//        } else {
//            System.out.println("No book title specified");
//            doDelete();
//        }
    }

    protected void takeDown() {
        if (targetBuyer != null && targetBuyer.length() > 0) {
            System.out.println("Buyer-agent " + getAID().getName() + " died, he bought " + targetBuyer + " book.");
        } else {
            System.out.println("Buyer-agent " + getAID().getName() + " terminating.");
        }
    }
}
