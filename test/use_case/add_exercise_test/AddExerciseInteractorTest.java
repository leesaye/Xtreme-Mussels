package use_case.add_exercise_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import data_access.RoutineDataAccessObject;
import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import entity.RoutineFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.add_exercise.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AddExerciseInteractorTest {

    HashMap<String, Routine> routineList = new HashMap<>();
    RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();

    @BeforeEach
    void init() {
        routineDataAccessObject.setPath("TestRoutineFile.json");
        routineDataAccessObject.setRoutineList(routineDataAccessObject.read());
        routineList = routineDataAccessObject.getRoutineList();
    }

    // hitting monthly limit issue
    @Test
    void successTest() {
        AddExerciseOutputBoundary addExercisePresenter = new AddExerciseOutputBoundary() {
            @Override
            public void prepareSuccessView(AddExerciseOutputData output) {
                Routine result = output.getRoutine();
                ArrayList<Exercise> e = result.getExercisesList();
                assertEquals(e.get(e.size() - 1).getName(), output.getExerciseName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected failure");
            }
        };

        AddExerciseInputData inputData = new AddExerciseInputData("test3", "archer pull up");
        AddExerciseInteractor interactor = new AddExerciseInteractor(routineDataAccessObject, addExercisePresenter);

        interactor.execute(inputData);
    }

    // hitting monthly limit issue
    @Test
    void failureTest() {

        AddExerciseOutputBoundary addExercisePresenter = new AddExerciseOutputBoundary() {
            @Override
            public void prepareSuccessView(AddExerciseOutputData data) {
                fail("Unexpected failure");
            }

            @Override
            public void prepareFailView(String error) {
                assertThat(error, org.hamcrest.CoreMatchers.either(is("Selected exercise does not exist")).or(is("Selected routine does not exist")));

            }
        };

        AddExerciseInputData inputData1 = new AddExerciseInputData("nonexistent routine", "burpee");
        AddExerciseInputData inputData2 = new AddExerciseInputData("test1", "nonexistent exercise");

        AddExerciseInteractor interactor = new AddExerciseInteractor(routineDataAccessObject, addExercisePresenter);

        interactor.execute(inputData1);
        interactor.execute(inputData2);
    }
}

class TestAddExerciseDataAccess{
    RoutineDataAccessObject addExerciseDataAccessObject = new RoutineDataAccessObject();

    HashMap<String, Routine> routineList = new HashMap<>();

    @BeforeEach
    void init() {
        addExerciseDataAccessObject.setPath("TestRoutineFile.json");
        addExerciseDataAccessObject.setRoutineList(addExerciseDataAccessObject.read());
        routineList = addExerciseDataAccessObject.getRoutineList();
    }

    //bug in the read() method- not fixed
    @Test
    void existsByNameTest() {
        assertTrue(addExerciseDataAccessObject.existsByName("test1"));
        assertFalse(addExerciseDataAccessObject.existsByName("test5"));
    }

    // hitting monthly limit issue
    @Test
    void existsByIdTest() {
        ArrayList<String> instr = new ArrayList<>();
        instr.add("\"Start in a standing position with your feet shoulder-width apart.\"");
        instr.add("\"Lower your body into a squat position by bending your knees and placing your hands on the floor in front of you.\"");
        instr.add("\"Kick your feet back into a push-up position.\"");
        instr.add("\"Perform a push-up");
        instr.add(" keeping your body in a straight line.\"");
        instr.add("\"Jump your feet back into the squat position.\"");
        instr.add("\"Jump up explosively");
        instr.add(" reaching your arms overhead.\"");
        instr.add("\"Land softly and immediately lower back into a squat position to begin the next repetition.\"");
        ArrayList<Exercise> e = new ArrayList<>();
        Exercise exerciseTest = ExerciseFactory.create("burpee", "cardiovascular system", "body weight", instr, "1160", 0, 0);
        e.add(exerciseTest);
        ArrayList<Exercise> e2 = addExerciseDataAccessObject.getExercisesByName("burpee", 1);
        assertTrue(e2.size() == e.size());
        Exercise ex1 = e.get(0);
        Exercise ex2 = e2.get(0);
        assertEquals(ex1.getName(), ex2.getName());
        assertEquals(ex1.getTarget(), ex2.getTarget());
        assertEquals(ex1.getEquipment(), ex2.getEquipment());
        assertEquals(ex1.getInstructions(), ex2.getInstructions());
        assertEquals(ex1.getId(), ex2.getId());
        assertEquals(ex1.getSets(), ex2.getSets());
        assertEquals(ex1.getReps(), ex2.getReps());
    }

    // hitting monthly limit issue
    @Test
    void getExercisesByNameReturnsEmpty(){
        assertTrue(addExerciseDataAccessObject.getExercisesByName("not-an-exercise", 1).isEmpty());
    }

    //implement interactor to use nullpointer
    @Test
    void addExerciseTest() {
        Routine r1 = ((addExerciseDataAccessObject.getRoutineList()).get("test1"));
        ArrayList<Exercise> exerciseList = r1.getExercisesList();
        ArrayList<String> instr = new ArrayList<>();
        instr.add("Start by hanging from a pull-up bar with an overhand grip, slightly wider than shoulder-width apart.");
        instr.add("Engage your core and pull your shoulder blades down and back.");
        instr.add("As you pull yourself up, bend one arm and bring your elbow towards your side, while keeping the other arm straight.");
        instr.add("Continue pulling until your chin is above the bar and your bent arm is fully flexed.");
        instr.add("Lower yourself back down with control, straightening the bent arm and repeating the movement on the other side.");
        instr.add("Alternate sides with each repetition.");
        ArrayList<Exercise> exercise = new ArrayList<>();
        Exercise ex1 = ExerciseFactory.create("archer pull up", "lats", "body weight", instr, "3293", 0, 0);
        exercise.add(ex1);
        addExerciseDataAccessObject.addExercise("test1", exercise);
        Exercise ex2 = exerciseList.get((exerciseList.size() - 1));
        assertEquals(ex1.getName(), ex2.getName());
        assertEquals(ex1.getTarget(), ex2.getTarget());
        assertEquals(ex1.getEquipment(), ex2.getEquipment());
        assertEquals(ex1.getInstructions(), ex2.getInstructions());
        assertEquals(ex1.getId(), ex2.getId());
        assertEquals(ex1.getSets(), ex2.getSets());
        assertEquals(ex1.getReps(), ex2.getReps());
    }

    @Test
    void getRoutineTest() {
        assertEquals(addExerciseDataAccessObject.getRoutine("test1"), routineList.get("test1"));
        assertEquals(addExerciseDataAccessObject.getRoutine("nonexistent routine"), null);
    }

}