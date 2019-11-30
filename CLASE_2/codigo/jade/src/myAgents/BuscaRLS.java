package examples.yellowPages;
 
import jade.core.Agent;
import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.*;
import java.util.Iterator;
 
public class BuscaRLS extends Agent {
   
     protected void setup() {
        ServiceDescription servicio = new ServiceDescription();
        servicio.setType("RLS");
         DFAgentDescription descripcion = new DFAgentDescription();
        descripcion.addLanguages("Castellano");
 
        descripcion.addServices(servicio);
        try {
            DFAgentDescription[] resultados = DFService.search(this,descripcion); 
            if (resultados.length == 0)
                System.out.println("Ningun agente ofrece el servicio");
 
            for (int i = 0; i < resultados.length; ++i) {
                System.out.println("El agente "+resultados[i].getName()+" ofrece sig. servicios:");
                Iterator servicios = resultados[i].getAllServices();
                int j = 1;
                while(servicios.hasNext()) {
                    servicio = (ServiceDescription)servicios.next();
                    System.out.println(j+"- "+servicio.getName());
                    System.out.println();
                    j++;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}