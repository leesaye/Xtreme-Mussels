package use_case.rename_routine;

import data_access.RoutineDataAccessObject;
import org.junit.jupiter.api.BeforeEach;
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

        RenameRoutineInputData inputData = new RenameRoutineInputData("1", "new");
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

        RenameRoutineInputData inputData = new RenameRoutineInputData("2", "new");
        RenameRoutineInteractor interactor = new RenameRoutineInteractor(dataAccess, renamePresenter);

        interactor.execute(inputData);
    }
}

/**
 * Class for testing the data access methods for this use case.
 */
class TestRenameRoutineDataAccess {

    RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();

    @BeforeEach
    void init() {
        routineDataAccessObject.setPath("TestRoutineFile.json");
        routineDataAccessObject.setRoutineList(routineDataAccessObject.read());
    }

    @Test
    void existsByNameTest() {
        assertTrue(routineDataAccessObject.existsByName("test1"));
    }

    @Test
    void changeNameTest() {
        routineDataAccessObject.changeName("test3", "test333");
        assertTrue(routineDataAccessObject.existsByName("test333"));

        // Restoring to original state
        routineDataAccessObject.changeName("test333", "test3");
    }
}

class TestDataAccess implements RenameRoutineDataAccessInterface {

    String id = "1";
    String name = "old";

    public TestDataAccess() {
    }

    @Override
    public boolean existsByName(String id) {
        return this.id.equals(id);
    }

    @Override
    public void changeName(String id, String name) {
        this.name = name;
    }
}