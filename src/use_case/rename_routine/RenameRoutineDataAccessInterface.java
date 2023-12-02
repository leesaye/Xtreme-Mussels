package use_case.rename_routine;

public interface RenameRoutineDataAccessInterface {

    boolean existsById(int id);

    void changeName(int id, String name);
}
