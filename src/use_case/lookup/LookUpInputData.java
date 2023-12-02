package use_case.lookup;

public class LookUpInputData {
    final private String value;
    final private String query;

    public LookUpInputData(String value, String query) {
        this.value = value;
        this.query = query;
    }

    public String getValue() {return value;}

    public String getQuery() {return query;}

}
