package entity;


public class RoutineFactory {
    /**
     * Requires: routine name is valid.
     *
     * @param routineName
     * @return
     */
    public Routine create(String routineName) {
        return new Routine(routineName);
    }
}
