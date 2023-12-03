package use_case.generate_routine;

import entity.Exercise;

import java.util.ArrayList;

public class GenerateRoutineOutputData {
    private ArrayList<Exercise> listOfExercises;
    private String name;


    public GenerateRoutineOutputData(ArrayList<Exercise> listOfExercises, String name) {
        this.listOfExercises = listOfExercises;
        this.name = name;

    }
    public ArrayList<Exercise> getListOfExercises() {
        return listOfExercises;
    }


    public String getName() {
        return name;
    }





}
