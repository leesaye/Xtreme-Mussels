package interface_adapter.edit_routine;

public class EditRoutineState {

    private String name;
    private String nameError;

    public EditRoutineState() {
    }

    public void setRoutineName(String name) {
        this.name = name;
    }

    public String getRoutineName() {
        return name;
    }

    public void setRoutineNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getRoutineNameError() {
        return nameError;
    }
}
