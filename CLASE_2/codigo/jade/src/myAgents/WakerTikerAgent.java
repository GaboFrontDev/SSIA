package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.core.behaviours.TickerBehaviour;

public class WakerTikerAgent extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new TickerBehaviour(this, 1000) {
            protected void onTick() {
                System.out.println("Agent " + myAgent.getLocalName() + ": tick=" + getTickCount());
            }
        });
        addBehaviour(new WakerBehaviour(this, 10000) {
            protected void handleElapsedTimeout() {
                System.out.println("Agent " + myAgent.getLocalName() + ": It's wakeup-time. Bye...");
                myAgent.doDelete();
            }
        });
    }
}