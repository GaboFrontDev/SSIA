package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class SLRAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new SRLBehaviour());
  } 

  private class SRLBehaviour extends OneShotBehaviour {

    float[] x = new float[]{1,2,3,4,5,6,7};
    float[] y = new float[]{2,4,6,8,10,12,14};

    public void action() {
      float sum_x = sum(x);
      float sum_y = sum(y);
      float dot = dot(x,y);
      int n = x.length;
      float b_1 = (n*dot-sum_x* sum_y) / (n*sum_square(x) - sum_x*sum_x);
      float b_0 = sum_y - b_1*sum_x;
      for(int i = 10; i < 21; i++) { 
        print("Prediction: " + (b_0 + b_1*i) );
      }
      myAgent.doDelete();
    } 


    public void print(String message) { 
      System.out.println(message);
    }


    

    public float sum(float[] array)  { 
      float sum = 0;
      for(int i = 0; i < array.length; i++ ) { 
        sum+= array[i];
      }
      return sum;
    }

    public float sum_square(float[] array)  { 
      float sum = 0;
      for(int i = 0; i < array.length; i++ ) { 
        sum+= array[i] * array[i];
      }
      return sum;
    }


    public float dot(float[] a ,float[] b)
    {
        float value = 0;
        float sum = 0 ;

        for (int i = 0 ; i < a.length ; i++)
        {
            value = a[i] * b [i];
            sum = sum +value ;
        }

        return sum;
    }
    
    public int onEnd() {
     myAgent.doDelete();
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}