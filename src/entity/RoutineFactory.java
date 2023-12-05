package entity;


import java.awt.*;
import java.util.ArrayList;

public class RoutineFactory {
    /**
     * Requires: routine name is valid.
     *
     * @param routineName
     * @return
     */
    public static Routine create(String routineName) {
        return new Routine(routineName);
    }
}
