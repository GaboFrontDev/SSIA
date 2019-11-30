package examples.yellowPages;
 
import jade.core.Agent;
import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.FIPAException;
 
public class OfreceRLS extends Agent {
  
    protected void setup() {
        DFAgentDescription descripcion = new DFAgentDescription();
        descripcion.setName(getAID());
        descripcion.addLanguages("Castellano");
        ServiceDescription servicio = new ServiceDescription();
        servicio.setType("RLS");
        servicio.setName("Linear Regression");
        descripcion.addServices(servicio);
 
        try {
            DFService.register(this, descripcion);
        }
        catch (FIPAException e) {
            e.printStackTrace();
        }
    }
 
    protected void takeDown() {
        try {
            DFService.deregister(this);
        }
        catch (FIPAException fe) {
            fe.printStackTrace();
        }
        System.out.println("El agente "+getAID().getName()+" ya no ofrece sus servicios.");
    }
}