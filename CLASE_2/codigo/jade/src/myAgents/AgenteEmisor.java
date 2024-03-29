package examples.messaging;
 
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
 
public class AgenteEmisor extends Agent {

    protected void setup() {
        addBehaviour(new EmisorComportaminento());
    }

   private class EmisorComportaminento extends SimpleBehaviour {
        boolean fin = false;
      
        public void action() {
            System.out.println(getLocalName() +": Preparandose para enviar un mensaje a receptor");
            AID id = new AID();
            id.setLocalName("receptor");
 
        // Creación del objeto ACLMessage
            ACLMessage mensaje = new ACLMessage(ACLMessage.REQUEST);
 
        //Rellenar los campos necesarios del mensaje
            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent("Greetings... What are you up to?");
 
        //Envia el mensaje a los destinatarios
            send(mensaje);
 
            System.out.println(mensaje.toString());
            fin = true;
        }
 
        public boolean done()
        {
            return fin;
        }
    }

}