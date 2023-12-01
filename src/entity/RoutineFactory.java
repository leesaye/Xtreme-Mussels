package entity;

import java.util.ArrayList;

public class RoutineFactory {
    public Routine create(String routineName, ArrayList<Exercise> exercises) {
        return new Routine(routineName, exercises);
    }
}