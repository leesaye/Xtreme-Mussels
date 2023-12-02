package entity;

import java.util.ArrayList;

public class RoutineFactory {
    public Routine create(String name) {
        return new Routine(name, new ArrayList<>());
    }
}
