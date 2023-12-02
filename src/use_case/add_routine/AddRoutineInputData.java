package use_case.add_routine;


public class AddRoutineInputData {
    private final String routineName;
    // private final ArrayList exercisesList;
    public AddRoutineInputData(String routineName){
        this.routineName = routineName;
    }


    public String getRoutineName(){
        return routineName;
    }
}
