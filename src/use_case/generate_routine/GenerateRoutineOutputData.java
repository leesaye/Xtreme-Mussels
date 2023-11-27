package use_case.generate_routine;

import entity.Exercise;

import java.util.ArrayList;

public class GenerateRoutineOutputData {
    private ArrayList<Exercise> listOfExercises;

    public GenerateRoutineOutputData(ArrayList<Exercise> listOfExercises) {
        this.listOfExercises = listOfExercises;
    }

    public ArrayList<Exercise> getListOfExercises() {
        return listOfExercises;
    }
}
