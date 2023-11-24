package use_case.adjust_setrep;

public class AdjustSetRepOutputData {
    private final String name; // display message that says eg "Edits to <name> saved"
    public AdjustSetRepOutputData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
