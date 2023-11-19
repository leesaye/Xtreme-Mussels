package interface_adapter.reorder_routine;

public class ReorderRoutineState {

    private String name;
    private String nameError;

    public ReorderRoutineState() {
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
