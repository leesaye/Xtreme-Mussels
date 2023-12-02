package use_case.adjust_setrep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class AdjustSetRepInteractorTest {

    ArrayList<Integer> sets;

    ArrayList<Integer> reps;

    @BeforeEach
    void init() {
        sets = new ArrayList<>();
        sets.add(3);
        sets.add(4);
        sets.add(5);

        reps = new ArrayList<>();
        reps.add(12);
        reps.add(13);
        reps.add(14);
    }

    @Test
    void successTest() {
        AdjustSetRepDataAccessInterface dataAccess = new TestDataAccess();

        AdjustSetRepOutputBoundary adjustPresenter = new AdjustSetRepOutputBoundary() {
            @Override
            public void prepareSuccessView(AdjustSetRepOutputData data) {
                assertEquals("temp", data.getName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("failure unexpected");
            }
        };



        AdjustSetRepInputData inputData = new AdjustSetRepInputData(1, sets, reps);
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



        AdjustSetRepInputData inputData = new AdjustSetRepInputData(2, sets, reps);
        AdjustSetRepInteractor interactor = new AdjustSetRepInteractor(dataAccess, adjustPresenter);

        interactor.execute(inputData);
    }
}

class TestDataAccess implements AdjustSetRepDataAccessInterface {

    int id = 1;

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
    public boolean existsById(int id) {
        return this.id == id;
    }

    @Override
    public void updateRoutine(int id, ArrayList<Integer> sets, ArrayList<Integer> reps) {
        this.sets = sets;
        this.reps = reps;
    }
}