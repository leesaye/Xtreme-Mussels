package use_case.edit_routine;

public class EditRoutineOutputData {
    private final String name; // display message that says eg "Edits to <name> saved"
    public EditRoutineOutputData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
