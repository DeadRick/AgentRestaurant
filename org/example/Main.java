package org.example;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class Main {
    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        // Имя контейнера и открытие GUI
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);

        try {
            AgentController agent1 = cc.createNewAgent("agent1", "org.example.VisitorAgent", null);
            agent1.start();

            AgentController agent2 = cc.createNewAgent("agent2", "org.example.SupervisorAgent", null);
            agent2.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
