package Domain;

public class BP extends MedicalAnalysis{
    private int systolicValue;
    private int diastolicValue;

    public BP(String date, int systolicValue, int diastolicValue) {
        super(date);
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
    }

    public boolean isResultOK(){
        if (this.systolicValue>=90 && this.systolicValue<=119)
            if (this.diastolicValue>=60 && this.diastolicValue<=79)
                return true;
        return false;
    }

    @Override
    public String toString() {
        return "BP{" +
                "systolicValue=" + systolicValue +
                ", diastolicValue=" + diastolicValue +
                ", date='" + date + '\'' +
                '}';
    }


}