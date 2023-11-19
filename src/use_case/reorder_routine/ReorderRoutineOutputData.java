package use_case.reorder_routine;

public class ReorderRoutineOutputData {
    private final String name; // display message that says eg "Edits to <name> saved"
    public ReorderRoutineOutputData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
