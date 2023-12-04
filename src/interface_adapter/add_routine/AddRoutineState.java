package interface_adapter.add_routine;


public class AddRoutineState {
    private String routineName = "";
    private String routineNameError = null;


    public AddRoutineState(AddRoutineState copy) {
        routineName = copy.routineName;
        routineNameError = copy.routineNameError;
    }

    public AddRoutineState() {
    }
    public String getRoutineName(){
        return routineName;
    }
    public String getRoutineNameError() {
        return routineNameError;
    }
    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }
    public void setRoutineNameError(String routineNameError) {
        this.routineNameError = routineNameError;
    }
    @Override
    public String toString() {
        return "AddRoutineState{" + "routinename = " + routineName + "}";
    }
}
