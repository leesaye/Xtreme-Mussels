package use_case.rename_routine;

public interface RenameRoutineDataAccessInterface {

    boolean existsByName(String id);

    void changeName(String id, String name);
}
