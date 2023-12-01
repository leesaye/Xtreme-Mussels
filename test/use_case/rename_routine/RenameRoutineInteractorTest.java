package use_case.rename_routine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RenameRoutineInteractorTest {

    @Test
    void successTest() {
        RenameRoutineDataAccessInterface dataAccess = new TestDataAccess();

        RenameRoutineOutputBoundary renamePresenter = new RenameRoutineOutputBoundary() {
            @Override
            public void prepareSuccessView(RenameRoutineOutputData data) {
                assertEquals("new", data.getName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Failure unexpected");
            }
        };

        RenameRoutineInputData inputData = new RenameRoutineInputData(1, "new");
        RenameRoutineInteractor interactor = new RenameRoutineInteractor(dataAccess, renamePresenter);

        interactor.execute(inputData);
    }

    // when id does not exist in data access
    @Test
    void failTest() {
        RenameRoutineDataAccessInterface dataAccess = new TestDataAccess();

        RenameRoutineOutputBoundary renamePresenter = new RenameRoutineOutputBoundary() {
            @Override
            public void prepareSuccessView(RenameRoutineOutputData data) {
                fail("Failure unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("2: Routine does not exist", error);
            }
        };

        RenameRoutineInputData inputData = new RenameRoutineInputData(2, "new");
        RenameRoutineInteractor interactor = new RenameRoutineInteractor(dataAccess, renamePresenter);

        interactor.execute(inputData);
    }

}

class TestDataAccess implements RenameRoutineDataAccessInterface {

    int id = 1;
    String name = "old";

    public TestDataAccess() {
    }

    @Override
    public boolean existsById(int id) {
        return id == this.id;
    }

    @Override
    public void changeName(int id, String name) {
        this.name = name;
    }

}