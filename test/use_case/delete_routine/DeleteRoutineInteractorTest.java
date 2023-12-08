package use_case.delete_routine;

import data_access.RoutineDataAccessObject;
import entity.Routine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DeleteRoutineInteractorTest {
    HashMap<String, Routine> routineList = new HashMap<>();
    RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();

    @BeforeEach
    void init() {
        routineDataAccessObject.setPath("TestRoutineFile.json");
        routineDataAccessObject.setRoutineList(routineDataAccessObject.read());
        routineList = routineDataAccessObject.getRoutineList();
    }


    @Test
    void successTest() {
        DeleteRoutineOutputBoundary deleteRoutinePresenter = new DeleteRoutineOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteRoutineOutputData output) {
                String removed_name = output.getRoutineName();
                assertFalse(routineList.containsKey(removed_name));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected failure");
            }
        };


        Routine routine_to_delete = routineList.get("test1");
        DeleteRoutineInputData inputData = new DeleteRoutineInputData("test1");
        DeleteRoutineInteractor interactor = new DeleteRoutineInteractor(routineDataAccessObject, deleteRoutinePresenter);
        interactor.execute(inputData);

        //add the routine back for future tests
        routineDataAccessObject.addRoutine(routine_to_delete);
    }

    @Test
    void failTest() {
        DeleteRoutineOutputBoundary deleteRoutinePresenter = new DeleteRoutineOutputBoundary() {

            @Override
            public void prepareSuccessView(DeleteRoutineOutputData data) {
                fail("Unexpected failure");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals(error, "Selected routine does not exist");
            }
        };


        DeleteRoutineInputData inputData = new DeleteRoutineInputData("nonexistent routine");
        DeleteRoutineInteractor interactor = new DeleteRoutineInteractor(routineDataAccessObject, deleteRoutinePresenter);
        interactor.execute(inputData);
    }

}

class TestDeleteRoutineDataAccess {
    RoutineDataAccessObject deleteRoutineDataAccessObject = new RoutineDataAccessObject();

    HashMap<String, Routine> routineList = new HashMap<>();

    @BeforeEach
    void init() {
        deleteRoutineDataAccessObject.setPath("TestRoutineFile.json");
        deleteRoutineDataAccessObject.setRoutineList(deleteRoutineDataAccessObject.read());
        routineList = deleteRoutineDataAccessObject.getRoutineList();
    }


    @Test
    void existsByNameTest() {
        assertTrue(deleteRoutineDataAccessObject.existsByName("test2"));
        assertFalse(deleteRoutineDataAccessObject.existsByName("test5"));
    }



    @Test
    void deleteRoutineTest() {
        Routine r = routineList.get("test3");
        deleteRoutineDataAccessObject.deleteRoutine("test3");
        assertFalse(routineList.containsKey("test3"));

        //put routine test1 back for future tests
        deleteRoutineDataAccessObject.addRoutine(r);
    }

}
