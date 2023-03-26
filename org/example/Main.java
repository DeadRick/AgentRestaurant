package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import org.example.JSONClasses.OrderDish;
import org.example.JSONClasses.VisitorOrder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    private static String path = "src/main/java/resources/visitors.json";
    protected static void generateVisitors(ContainerController cc) throws IOException, StaleProxyException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(path);
        VisitorOrder[] visitorOrders = objectMapper.readValue(file, VisitorOrder[].class);

        for (VisitorOrder visitorOrder : visitorOrders) {
            String name = visitorOrder.getVis_name();
            String visOrdStarted = visitorOrder.getVis_ord_started();
            String visOrdEnded = visitorOrder.getVis_ord_ended();
            int visOrdTotal = visitorOrder.getVis_ord_total();
            List<OrderDish> visOrdDished = visitorOrder.getVis_ord_dishes();

            Object[] arguments = new Object[] {name, visOrdStarted, visOrdEnded, visOrdTotal, visOrdDished};
            AgentController agent = cc.createNewAgent(visitorOrder.getVis_name(), "org.example.VisitorAgent", arguments);
            agent.start();
        }
    }
    public static void runProgram() {
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        // Имя контейнера и открытие GUI
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);
        try {
            AgentController supervisor = cc.createNewAgent("Supervisor", "org.example.SupervisorAgent", null);
            supervisor.start();
            AgentController orderAgent = cc.createNewAgent("OrderAgent", "org.example.OrderAgent", null);
            generateVisitors(cc);
        } catch (Exception e) {
            e.printStackTrace(); // #TODO Log4J
        }
    }

    public static void main(String[] args) {
        runProgram();
    }
}
