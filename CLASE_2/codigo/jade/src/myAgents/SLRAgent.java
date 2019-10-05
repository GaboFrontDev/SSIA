package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class SLRAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new SRLBehaviour());
  } 

  private class SRLBehaviour extends OneShotBehaviour {

    public void action() {
        System.out.println("Trying to make a SLR");
    } 
    
    public int onEnd() {
     myAgent.doDelete();
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}