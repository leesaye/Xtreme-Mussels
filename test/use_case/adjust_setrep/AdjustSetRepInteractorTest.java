package use_case.adjust_setrep;

import data_access.RoutineDataAccessObject;
import entity.Exercise;
import entity.Routine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.add_routine.AddRoutineDataAccessInterface;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdjustSetRepInteractorTest {

    ArrayList<Integer> sets;

    ArrayList<Integer> reps;

    @BeforeEach
    void init() {
        sets = new ArrayList<>();
        sets.add(3);

        reps = new ArrayList<>();
        reps.add(12);
    }

    @Test
    void successTest() {
        Routine routine = new Routine("1");
        ArrayList<Exercise> exercise = new ArrayList<>();
        Exercise bicep = new Exercise("Bicep curls", "bicep", "Dumbbells", null, "bicep curls", 0, 0);
        exercise.add(bicep);
        routine.setExercisesList(exercise);

        RoutineDataAccessObject dataAccess = new RoutineDataAccessObject();
        dataAccess.addRoutine(routine);

        AdjustSetRepOutputBoundary adjustPresenter = new AdjustSetRepOutputBoundary() {
            @Override
            public void prepareSuccessView(AdjustSetRepOutputData data) {
                assertEquals("1", data.getName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("failure unexpected");
            }
        };

        AdjustSetRepInputData inputData = new AdjustSetRepInputData("1", sets, reps);
        AdjustSetRepInteractor interactor = new AdjustSetRepInteractor(dataAccess, adjustPresenter);

        interactor.execute(inputData);
    }

    @Test
    void failureTest() {
        RoutineDataAccessObject dataAccess = new RoutineDataAccessObject();

        AdjustSetRepOutputBoundary adjustPresenter = new AdjustSetRepOutputBoundary() {
            @Override
            public void prepareSuccessView(AdjustSetRepOutputData data) {
                fail("failure unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("2: Routine does not exist", error);
            }
        };

        AdjustSetRepInputData inputData = new AdjustSetRepInputData("2", sets, reps);
        AdjustSetRepInteractor interactor = new AdjustSetRepInteractor(dataAccess, adjustPresenter);

        interactor.execute(inputData);
    }
}

class TestAdjustSetRepDataAccess {

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
    void updateRoutineTest() {
        ArrayList<Integer> sets = new ArrayList<>();
        ArrayList<Integer> reps = new ArrayList<>();
        for  (int i = 0; i < routineDataAccessObject.getRoutine("test1").getExercisesList().size(); i++) {
            sets.add(1);
            reps.add(2);
        }
        routineDataAccessObject.updateRoutine("test1", sets, reps);
        assertEquals(routineDataAccessObject.getRoutine("test1").getExercisesList().get(0).getSets(), 1);
        assertEquals(routineDataAccessObject.getRoutine("test1").getExercisesList().get(0).getReps(), 2);
    }

    @Test
    void getRoutineTest() {
        assertEquals(routineDataAccessObject.getRoutine("test1").getRoutineName(), "test1");
        assertEquals(routineDataAccessObject.getRoutine("test1").getExercisesList().get(0).getName(), "astride jumps (male)");
    }
}