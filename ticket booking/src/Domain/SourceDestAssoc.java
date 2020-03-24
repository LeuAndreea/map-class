package Domain;

public class SourceDestAssoc {
    private String id;
    private String sourceCity;
    private String destinationCity;

    public SourceDestAssoc(String id, String sourceCity, String destinationCity) {
        this.id = id;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
    }

    public String getId() {
        return id;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Override
    public String toString() {
        return  sourceCity + " - " +destinationCity ;
    }
}
