package entity;

import java.util.ArrayList;

public class RoutineFactory {
    public Routine create(String name, ArrayList<Exercise> exercises) {
        return new Routine(name, exercises);
    }
}
