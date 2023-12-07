package use_case.delete_exercise;


import entity.Routine;


public class DeleteExerciseOutputData {
    private final String routineName;
    private final String exerciseName;
    private final Routine routine;

    public DeleteExerciseOutputData(String routineName, String exerciseName, Routine routine) {
        this.routineName = routineName;
        this.exerciseName = exerciseName;
        this.routine = routine;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getRoutineName() {
        return routineName;
    }

    public Routine getRoutine() {return routine;}

}
