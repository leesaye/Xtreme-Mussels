package interface_adapter.delete_routine;


public class DeleteRoutineState {
    private String routineName;

    private String nameError;

    public DeleteRoutineState() {
    }

    public String getName() {
        return routineName;
    }

    public void setName(String name) {
        this.routineName = name;
    }

    public void deleteRoutineNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getRoutineNameError() {
        return nameError;
    }
}
