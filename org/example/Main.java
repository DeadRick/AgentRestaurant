package org.example;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class Main {
//    public static VisitorsOrder[] readJson() {
//        VisitorsOrder[] visitorsOrder = new VisitorsOrder[];
//        JSONArray a = (JSONArray) parser.parse(new FileReader("c:\\exer4-courses.json"));
//    }
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
            AgentController agent1 = cc.createNewAgent("Visitor", "org.example.VisitorAgent", null);
            agent1.start();

        } catch (Exception e) {
            e.printStackTrace(); // #TODO Log4J
        }
    }
    public static void main(String[] args) {
        runProgram();
    }
}
