package use_case.delete_routine;

public class DeleteRoutineInputData {
    final private String routineName;

    public DeleteRoutineInputData(String routineName){
        this.routineName = routineName;
    }

    public String getRoutineName() {
        return routineName;
    }


}
