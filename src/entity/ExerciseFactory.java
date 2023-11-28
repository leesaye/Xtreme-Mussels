package entity;

import java.util.ArrayList;

public class ExerciseFactory {
    public Exercise create(String name, String target, String equipment, ArrayList<String> instructions, String id, int sets, int reps) {
        return new Exercise(name, target, equipment, instructions, id, sets, reps);
    }
}