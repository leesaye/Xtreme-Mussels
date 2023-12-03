package use_case.lookup_routine;

import data_access.ExerciseDataAccessObject;
import data_access.RoutineDataAccessObject;
import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import entity.RoutineFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.lookup.LookUpInputData;
import use_case.lookup.LookUpInteractor;
import use_case.lookup.LookUpOutputBoundary;
import use_case.lookup.LookUpOutputData;
import use_case.rename_routine.RenameRoutineDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class LookUpRoutineInteractorTest {
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
        LookUpRoutineOutputBoundary lookUpRoutinePresenter = new LookUpRoutineOutputBoundary() {
            @Override
            public void prepareSuccessView(LookUpRoutineOutputData output) {
                assertEquals(routineList.get("test3").getExercisesList().get(0).getName(), output.getRoutine().getExercisesList().get(0).getName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected failure");
            }
        };

        LookUpRoutineInputData inputData = new LookUpRoutineInputData("test3");
        LookUpRoutineInteractor interactor = new LookUpRoutineInteractor(routineDataAccessObject, lookUpRoutinePresenter);

        interactor.execute(inputData);
    }

    @Test
    void failureTest() {
        LookUpRoutineOutputBoundary lookUpRoutinePresenter = new LookUpRoutineOutputBoundary() {
            @Override
            public void prepareSuccessView(LookUpRoutineOutputData data) {
                fail("Unexpected failure");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Invalid routine name.", error);
            }
        };

        LookUpRoutineInputData inputData = new LookUpRoutineInputData("test111");
        LookUpRoutineInteractor interactor = new LookUpRoutineInteractor(routineDataAccessObject, lookUpRoutinePresenter);

        interactor.execute(inputData);
    }
}

class TestRoutineDataAccess {
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
    void getRoutineTest() {
        assertEquals(routineDataAccessObject.getRoutine("test2").getName(), "test2");
        assertEquals(routineDataAccessObject.getRoutine("test2").getExercisesList().get(0).getName(), "astride jumps (male)");
    }
}
