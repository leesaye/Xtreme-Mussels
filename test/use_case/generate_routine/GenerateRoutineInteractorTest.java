package use_case.generate_routine;

import data_access.RoutineDataAccessObject;
import entity.Exercise;
import entity.Routine;
import interface_adapter.generate_routine.GenerateRoutinePresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.generate_routine.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateRoutineInteractorTest {
    String name;
    String target;
    int number;
    GenerateRoutineDataAccessInterface dataAccess;
    GenerateRoutineDataAccessInterface failDataAccess;
    ArrayList<Exercise> correctOutput;
    Exercise bicepCurls;

    ArrayList<String> instructions;

    @BeforeEach
    void init() {
        name = "routine 1";
        target = "arms";
        number = 7;
        dataAccess = new TestDataAccess();
        instructions = new ArrayList<>();
        instructions.add("do this");
        instructions.add("step 2");
        bicepCurls = new Exercise("bicep curls", "arms", "dumbbells", instructions, "22", 3, 5);
        correctOutput = new ArrayList<>();
        correctOutput.add(bicepCurls);
        failDataAccess = new TestDataAccessNoExercises();
    }

    @Test
    void successTest() {
        GenerateRoutineOutputBoundary presenter = new GenerateRoutineOutputBoundary(){

            @Override
            public void prepareSuccessView(GenerateRoutineOutputData generateRoutineOutputData) {
                ArrayList<Exercise> actualExercises = generateRoutineOutputData.getListOfExercises();

                // Check if the sizes are the same
                assertEquals(correctOutput.size(), actualExercises.size());
                for (int i = 0; i < correctOutput.size(); i++) {
                    Exercise expectedExercise = correctOutput.get(i);
                    Exercise actualExercise = actualExercises.get(i);

                    assertEquals(expectedExercise.getName(), actualExercise.getName());
                    assertEquals(expectedExercise.getTarget(), actualExercise.getTarget());
                }
                assertEquals("routine 1", generateRoutineOutputData.getName());

            }

            @Override
            public void prepareFailedView(String message) {
                fail("could not create routine");
            }
        };

        GenerateRoutineInputData input = new GenerateRoutineInputData("arms", 1, "routine 1");
        GenerateRoutineInteractor interactor = new GenerateRoutineInteractor(dataAccess, presenter);
        interactor.execute(input);
    }
    @Test
    void failuretest() {
        GenerateRoutineOutputBoundary presenter = new GenerateRoutineOutputBoundary() {
            @Override
            public void prepareSuccessView(GenerateRoutineOutputData generateRoutineOutputData) {

            }

            @Override
            public void prepareFailedView(String message) {
                assertEquals("Routine could not created due to insufficient number of exercises", message); // Update the expected failure message
            }
        };

        // Assume "invalidTarget" is not present in the TestDataAccess
        GenerateRoutineInputData input = new GenerateRoutineInputData("invalidTarget", 1, "routineName");
        GenerateRoutineInteractor interactor = new GenerateRoutineInteractor(failDataAccess, presenter);
        interactor.execute(input);
    };
}

/**
 * Class for testing the data access methods for this use case.
 */
class TestGenerateRoutineDataAccess {

    RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();

    @BeforeEach
    void init() {
        routineDataAccessObject.setPath("TestRoutineFile.json");
        routineDataAccessObject.setRoutineList(routineDataAccessObject.read());
    }

    @Test
    void getExercisesByTargetTest() {
        assertEquals(routineDataAccessObject.getExercisesByTarget("abs", 2).get(0).getTarget(), "abs");
    }

    @Test
    void addRoutineTest() {
        Routine routine = new Routine("dao test generate routine");
        routine.setExercisesList(routineDataAccessObject.getExercisesByTarget("abs", 2));
        routineDataAccessObject.addRoutine(routine);
        assertTrue(routineDataAccessObject.existsByName("dao test generate routine"));

        // Restoring to original state
        routineDataAccessObject.removeRoutine("dao test generate routine");
    }
}


class TestDataAccess implements GenerateRoutineDataAccessInterface {

    //dummy arraylist to store te
    public ArrayList<Exercise> exercises = new ArrayList<Exercise>();

    public TestDataAccess() {
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("do this");
        instructions.add("step 2");
        Exercise bicepCurls = new Exercise("bicep curls", "arms", "dumbbells", instructions, "22", 3, 5);
        exercises.add(bicepCurls);
    }


    @Override
    public ArrayList<Exercise> getExercisesByTarget(String target, int numberOfExercises) {
        return exercises;
    }

    @Override
    public void addRoutine(Routine routine) {

    }
}

class TestDataAccessNoExercises implements GenerateRoutineDataAccessInterface {
    @Override
    public ArrayList<Exercise> getExercisesByTarget(String target, int numberOfExercises) {
        return new ArrayList<>();
    }

    @Override
    public void addRoutine(Routine routine) {
        // Implement if needed
    }
}
