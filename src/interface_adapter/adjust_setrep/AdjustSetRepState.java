package interface_adapter.adjust_setrep;

import entity.Exercise;

import java.util.ArrayList;

public class AdjustSetRepState {

    private String name;

    private int id;

    private ArrayList<Exercise> exercises = null;

    private String nameError;

    public AdjustSetRepState() {
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Object[][] getExercisesReps() {
        ArrayList<Object[]> tempExercises = new ArrayList<>();

        for (Exercise exercise : this.exercises) {
            tempExercises.add(new Object[]{exercise.getName(), exercise.getRepsSets()});
        }

        Object[][] tempArray = new Object[tempExercises.size()][2];

        for (int i = 0; i < tempExercises.size(); i++) {
            tempArray[i] = tempExercises.get(i);
        }

        return tempArray;
    }

}
