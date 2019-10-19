package testing;

import jade.core.Agent;

/**
 * BookBuyerAgent
 */
public class BookBuyerAgent extends Agent {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void setup() {
        print("Hola mis amigos, el id es: " + getAID().getName() + "y estoy listo");
    }

}

public void print(String valString) {
    System.out.println(valString);
}