package Domain;

import java.util.Vector;

public class FirstDegreeEquation extends Equation{

    public FirstDegreeEquation(Vector<Double> coefficients) {
        super(coefficients);
    }

    public Vector<Double> getSolutions(){
        //ax+b=0; x=-b/a

        double a= this.coefficients.elementAt(0);
        double b=this.coefficients.elementAt(1);

        Vector<Double> sol = new Vector();
        sol.add((-1)*b/a);

        return sol;
    }

    @Override
    public String toString() {
        return Double.toString(this.coefficients.elementAt(0)) + "*x+" + Double.toString(this.coefficients.elementAt(1));
    }


}
