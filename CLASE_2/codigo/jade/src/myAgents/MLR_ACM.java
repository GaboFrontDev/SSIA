package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class MLR_ACM extends Agent {

  protected void setup() {
		System.out.println("Agent "+getLocalName()+" started.");
		addBehaviour(new MLRBehaviour());
  } 

  private class MLRBehaviour extends OneShotBehaviour {
	public void action() {
		double[][] X = new double[][]{{4,0,1},{7,1,1},{6,1,0},{2,0,0},{3,0,1}};
		double[][] Y = new double[][]{{27},{29},{23},{20},{21}};
		RealMatrix XMatrix = new Array2DRowRealMatrix(X);
		RealMatrix YMatrix = new Array2DRowRealMatrix(Y);
		RealMatrix XTranspose = XMatrix.transpose();
		RealMatrix prodTranspose = XTranspose.multiply(XMatrix);


		DecompositionSolver solver = new LUDecomposition(prodTranspose).getSolver();
		RealMatrix I = new Array2DRowRealMatrix(Y);
		RealMatrix prodInverse = solver.solve(I);


		// RealMatrix squareEstimates = prodInverse.multiply(XTranspose.multiply(YMatrix));
	}
	
	public int onEnd() {
	 myAgent.doDelete();
	  return super.onEnd();
	} 
  }    // END of inner class ...Behaviour
}