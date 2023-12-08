package use_case.delete_routine;

public interface DeleteRoutineDataAccessInterface {
    boolean existsByName(String routineName);

    void deleteRoutine(String routineName);

}
