package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import Jama.Matrix;
import Jama.QRDecomposition;


public class MLR extends Agent {

  protected void setup() {
		System.out.println("Agent "+getLocalName()+" started.");
		
		addBehaviour(new MLRBehaviour());
  } 

  public class MLRBehaviour extends OneShotBehaviour {
	private int N;        // number of samples
    private int p;        // number of dependent variables
    private Matrix beta;  // regression coefficients

	public void action() {
		double[][] x = { {  1,  10,  20 },
                         {  1,  20,  40 },
                         {  1,  40,  15 },
                         {  1,  80, 100 },
                         {  1, 160,  23 },
                         {  1, 200,  18 } };
        double[] y = { 243, 483, 508, 1503, 1764, 2129 };
        multipleLinearRegression(x, y);

        System.out.printf("%.2f + %.2f beta1 + %.2f beta2 \n",
                      this.beta(0), this.beta(1), this.beta(2));
	}

	public void multipleLinearRegression(double[][] x, double[] y) {
        if (x.length != y.length) throw new RuntimeException("dimensions don't agree");
        N = y.length;
        p = x[0].length;

        Matrix X = new Matrix(x);

        Matrix Y = new Matrix(y, N);
		System.out.print(Y);
        // find least squares solution
        QRDecomposition qr = new QRDecomposition(X);
        beta = qr.solve(Y);


    }


	public double beta(int j) {
        return beta.get(j, 0);
    }


	
	public int onEnd() {
	 myAgent.doDelete();
	  return super.onEnd();
	} 
  }    // END of inner class ...Behaviour
}