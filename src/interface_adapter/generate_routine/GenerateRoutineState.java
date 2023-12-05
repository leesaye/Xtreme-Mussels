package interface_adapter.generate_routine;

import entity.Exercise;

import java.util.ArrayList;

public class GenerateRoutineState {
    private String errorMessage;
    private ArrayList<Exercise> routineList;

    private int sets;
    private int reps;

    private String targetBody;
    private int numberOfExercises;
    private String routineName;
    public GenerateRoutineState(GenerateRoutineState copy) {
        routineList = copy.routineList;
        errorMessage = copy.errorMessage;
        sets = copy.sets;
        reps = copy.reps;
        targetBody = copy.targetBody;
        numberOfExercises = copy.numberOfExercises;
        routineName = copy.routineName;
    }

    public GenerateRoutineState() {}

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public ArrayList<Exercise> getRoutineList() {
        return routineList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setRoutineList(ArrayList<Exercise> routineList) {
        this.routineList = routineList;
    }

    public void setRoutineName(String routineName) {this.routineName = routineName;}

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTargetBody() {
        return targetBody;
    }

    public void setTargetBody(String targetBody) {
        this.targetBody = targetBody;
    }

    public int getNumberOfExercises() {
        return numberOfExercises;
    }

    public void setNumberOfExercises(int numberOfExercises) {
        this.numberOfExercises = numberOfExercises;
    }

    public String getRoutineName() {
        return routineName;
    }
}
