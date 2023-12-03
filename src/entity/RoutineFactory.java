package entity;


public class RoutineFactory {
    public static Routine create(String routineName) {
        return new Routine(routineName);
    }
}
