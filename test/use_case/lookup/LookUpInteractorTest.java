package use_case.lookup;

import data_access.ExerciseDataAccessObject;
import entity.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class LookUpInteractorTest {
    ArrayList<Exercise> exercisesTarget;
    ArrayList<Exercise> exercisesName;
    ExerciseDataAccessObject daoTarget = new ExerciseDataAccessObject();
    ExerciseDataAccessObject daoName = new ExerciseDataAccessObject();

    @BeforeEach
    void init() {
        exercisesTarget = daoTarget.getExercisesByQuery("abs", "target");
        exercisesName = daoName.getExercisesByQuery("lever seated hip abduction", "name");
    }

    @Test
    void successTestTarget() {
        LookUpOutputBoundary lookUpPresenter = new LookUpOutputBoundary() {
            @Override
            public void prepareSuccessView(LookUpOutputData output) {
                assertEquals(exercisesTarget.get(0).getName(), output.getExercises().get(0).getName());
                assertEquals(exercisesTarget.get(exercisesTarget.size() - 1).getName(), output.getExercises().get(output.getExercises().size() - 1).getName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected failure");
            }
        };

        LookUpInputData inputData = new LookUpInputData("abs", "target");
        LookUpInteractor interactor = new LookUpInteractor(daoTarget, lookUpPresenter);

        interactor.execute(inputData);
    }

    @Test
    void successTestName() {
        LookUpOutputBoundary lookUpPresenter = new LookUpOutputBoundary() {
            @Override
            public void prepareSuccessView(LookUpOutputData output) {
                assertEquals(exercisesName.get(0).getName(), output.getExercises().get(0).getName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected failure");
            }
        };

        LookUpInputData inputData = new LookUpInputData("lever seated hip abduction", "name");
        LookUpInteractor interactor = new LookUpInteractor(daoName, lookUpPresenter);

        interactor.execute(inputData);
    }

    // NOTE: Target must be exactly correct
    @Test
    void failureTestName() {
        LookUpOutputBoundary lookUpPresenter = new LookUpOutputBoundary() {
            @Override
            public void prepareSuccessView(LookUpOutputData data) {
                fail("Unexpected failure");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("No exercises found.", error);
            }
        };

        LookUpInputData inputData = new LookUpInputData("horse", "name");
        LookUpInteractor interactor = new LookUpInteractor(daoName, lookUpPresenter);

        interactor.execute(inputData);
    }
}

/**
 * Class for testing the data access methods for this use case.
 */
class TestLookUpExercisesDataAccess {
    ExerciseDataAccessObject exerciseDataAccessObject = new ExerciseDataAccessObject();

    @Test
    void getExercisesByQueryTest() {
        assertEquals(exerciseDataAccessObject.getExercisesByQuery("calves", "target").get(0).getTarget(), "calves");
        assertEquals(exerciseDataAccessObject.getExercisesByQuery("calves", "target").get(0).getName(), "ankle circles");
        assertEquals(exerciseDataAccessObject.getExercisesByQuery("sit up", "name").get(0).getName(), "3/4 sit-up");
    }
}