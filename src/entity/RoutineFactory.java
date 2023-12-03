package entity;


public class RoutineFactory {
    public Routine create(String routineName) {
        return new Routine(routineName);
    }
}
