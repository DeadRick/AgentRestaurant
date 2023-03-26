package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import org.example.JSONClasses.VisitorOrder;

import java.io.File;
import java.io.IOException;

public class Main {
    // "src/main/resources/visitors.json"
    protected static void generateVisitors(ContainerController cc) throws IOException, StaleProxyException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/main/resources/visitors.json");
        VisitorOrder[] visitorOrders = objectMapper.readValue(file, VisitorOrder[].class);

        for (VisitorOrder visitorOrder : visitorOrders) {
            AgentController agent = cc.createNewAgent(visitorOrder.getVis_name(), "org.example.VisitorAgent", null);
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
            AgentController agent2 = cc.createNewAgent("Supervisor", "org.example.SupervisorAgent", null);
            agent2.start();
            generateVisitors(cc);

        } catch (Exception e) {
            e.printStackTrace(); // #TODO Log4J
        }
    }

    public static void main(String[] args) {
        runProgram();
    }
}
