package Domain;

import java.util.ArrayList;
import java.util.Vector;

public class Equation {

    public Equation(Vector<Double> coefficients) {
        this.coefficients = coefficients;
    }

    protected Vector<Double> coefficients;

    public Vector<Double> getCoefficients() {
        return coefficients;
    }

    public int getDegree(){
        return this.coefficients.size();
    }

    public  Vector<Double> getSolutions(){
        return null;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "coefficients=" + coefficients +
                '}';
    }
}
