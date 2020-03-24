package Domain;

import java.util.Vector;

public class SecondDegreeEquation extends Equation{
    public SecondDegreeEquation(Vector<Double> coefficients) {
        super(coefficients);
    }

    @Override
    public String toString() {
        return Double.toString(this.coefficients.elementAt(0))+"*x^2+"+Double.toString(this.coefficients.elementAt(1)) + "*x+" + Double.toString(this.coefficients.elementAt(2));
    }

    public Vector<Double> getSolutions(){
        //a*x^2 + bx +c

        double a = this.coefficients.elementAt(0);
        double b = this.coefficients.elementAt(1);
        double c = this.coefficients.elementAt(2);

        double delta= Math.pow(b,2) - 4*a*c;

        double solution1= ((-1)*b + Math.sqrt(delta))/2*a;
        double solution2= ((-1)*b - Math.sqrt(delta))/2*a;

        Vector<Double> sol = new Vector();
        sol.add(solution1);
        sol.add(solution2);

        return sol;



    }

}
