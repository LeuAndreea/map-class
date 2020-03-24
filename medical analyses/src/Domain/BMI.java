package Domain;

public class BMI extends MedicalAnalysis{
    private double value;

    public BMI(String date, double value) {
        super(date);
        this.value = value;
    }

    public boolean isResultOK() {
        if (this.value>=18.5 && this.value<=25)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "BMI{" +
                "value=" + value +
                ", date='" + date + '\'' +
                '}';
    }
}
