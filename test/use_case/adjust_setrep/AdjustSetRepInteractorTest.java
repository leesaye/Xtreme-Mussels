package use_case.adjust_setrep;

import data_access.RoutineDataAccessObject;
import entity.Exercise;
import entity.Routine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.add_routine.AddRoutineDataAccessInterface;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
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
//        AdjustSetRepDataAccessInterface dataAccess = new TestDataAccess();
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
        AdjustSetRepDataAccessInterface dataAccess = new TestDataAccess();

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

class TestDataAccess implements AdjustSetRepDataAccessInterface {

    String id = "1";

    ArrayList<Integer> sets = new ArrayList<>();

    ArrayList<Integer> reps = new ArrayList<>();

    public TestDataAccess() {
        sets.add(0);
        sets.add(1);
        sets.add(2);
        reps.add(9);
        reps.add(10);
        reps.add(11);
    }

    @Override
    public boolean existsByName(String id) {
        return this.id.equals(id);
    }

    @Override
    public void updateRoutine(String id, ArrayList<Integer> sets, ArrayList<Integer> reps) {
        this.sets = sets;
        this.reps = reps;
    }

    @Override
    public Routine getRoutine(String id) {
        return null;
    }
}