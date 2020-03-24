package Domain;

public class MedicalAnalysis {
    protected String date;

    public MedicalAnalysis() { }

    public MedicalAnalysis(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public int getMonth(){
        return Integer.parseInt(this.getDate().substring(3,5));
    }

    public int getDay(){
        return Integer.parseInt(this.getDate().substring(0,3));
    }

    /*public int getYear(){
        Integer.parseInt(this.getDate().substring(0,3));
    }*/

    public boolean isResultOK(){return true; }

    @Override
    public String toString() {
        return "MedicalAnalysis{" +
                "date='" + date + '\'' +
                '}';
    }
}