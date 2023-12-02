package use_case.generate_routine;

import entity.Exercise;

import java.util.ArrayList;

public class GenerateRoutineOutputData {
    private ArrayList<Exercise> listOfExercises;
    private String name;
    private int sets;
    private int reps;

    public GenerateRoutineOutputData(ArrayList<Exercise> listOfExercises, String name, int sets, int reps) {
        this.listOfExercises = listOfExercises;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
    }
    public ArrayList<Exercise> getListOfExercises() {
        return listOfExercises;
    }


    public String getName() {
        return name;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

}
