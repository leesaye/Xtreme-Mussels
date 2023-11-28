package use_case.lookup;

import entity.Exercise;

import java.util.ArrayList;

public class LookUpInputData {
//    final private ArrayList<Exercise> exercises;
    final private String target;
    final private String name;
    public LookUpInputData(String target, String name) {
//        this.exercises = exercises;
        this.target = target;
        this.name = name;
    }

    public String getTarget() {return target;}

    public String getName() {return name;}

//    public ArrayList<Exercise> getExercises() {
//        return exercises;
//    }

}
