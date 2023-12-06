package use_case.delete_exercise_test;

import data_access.RoutineDataAccessObject;
import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.add_exercise.AddExerciseInputData;
import use_case.add_exercise.AddExerciseInteractor;
import use_case.add_exercise.AddExerciseOutputBoundary;
import use_case.add_exercise.AddExerciseOutputData;
import use_case.delete_exercise.DeleteExerciseInputData;
import use_case.delete_exercise.DeleteExerciseInteractor;
import use_case.delete_exercise.DeleteExerciseOutputBoundary;
import use_case.delete_exercise.DeleteExerciseOutputData;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DeleteExerciseInteractorTest {
    HashMap<String, Routine> routineList = new HashMap<>();
    RoutineDataAccessObject routineDataAccessObject = new RoutineDataAccessObject();

    @BeforeEach
    void init() {
        routineDataAccessObject.setPath("TestRoutineFile.json");
        routineDataAccessObject.setRoutineList(routineDataAccessObject.read());
        routineList = routineDataAccessObject.getRoutineList();
    }

    //discuss testing for routine with multiple instances of the same exercise
    @Test
    void successTest() {
        DeleteExerciseOutputBoundary deleteExercisePresenter = new DeleteExerciseOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteExerciseOutputData output) {
                Routine result = output.getRoutine();
                ArrayList<Exercise> e = result.getExercisesList();
                boolean isRemoved = true;
                for (int i = 0; i < e.size(); i++){
                    if(e.get(i).getName() == output.getExerciseName()){
                        isRemoved = false;
                    }

                }
                assertTrue(isRemoved);
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected failure");
            }
        };



        DeleteExerciseInputData inputData = new DeleteExerciseInputData("test2", "bear crawl");
        DeleteExerciseInteractor interactor = new DeleteExerciseInteractor(routineDataAccessObject, deleteExercisePresenter);

        interactor.execute(inputData);

        //add exercise back and forth step to routine test2 for future tests
        ArrayList<String> instr = new ArrayList<>();
        instr.add("\"Start on all fours with your hands directly under your shoulders and your knees directly under your hips.\"");
        instr.add("\"Lift your knees slightly off the ground");
        instr.add(" keeping your back flat and your core engaged.\"");
        instr.add("Move your right hand and left foot forward simultaneously");
        instr.add(" followed by your left hand and right foot.\"");
        instr.add("\"Continue crawling forward");
        instr.add(" alternating your hand and foot movements.\"");
        instr.add("\"Maintain a steady pace and keep your core tight throughout the exercise.\"");
        instr.add("\"Continue for the desired distance or time.\"");
        ArrayList<Exercise> put_back  = new ArrayList<>();
        Exercise e = ExerciseFactory.create("bear crawl", "cardiovascular system", "body weight", instr, "3360", 0, 0);
        put_back.add(e);
        routineDataAccessObject.addExercise("test2", put_back);
    }

    @Test
    void failureTest() {

        DeleteExerciseOutputBoundary deleteExercisePresenter = new DeleteExerciseOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteExerciseOutputData data) {
                fail("Unexpected failure");
            }

            @Override
            public void prepareFailView(String error) {
                assertThat(error, org.hamcrest.CoreMatchers.either(is("Selected exercise does not exist in specified routine")).or(is("Selected routine does not exist")));

            }
        };

        DeleteExerciseInputData inputData1 = new DeleteExerciseInputData("nonexistent routine", "burpee");
        DeleteExerciseInputData inputData2 = new DeleteExerciseInputData("test1", "nonexistent exercise");

        DeleteExerciseInteractor interactor = new DeleteExerciseInteractor(routineDataAccessObject, deleteExercisePresenter);

        interactor.execute(inputData1);
        interactor.execute(inputData2);
    }
}

class TestDeleteExerciseDataAccess{
    RoutineDataAccessObject deleteExerciseDataAccessObject = new RoutineDataAccessObject();

    HashMap<String, Routine> routineList = new HashMap<>();

    @BeforeEach
    void init() {
        deleteExerciseDataAccessObject.setPath("TestRoutineFile.json");
        deleteExerciseDataAccessObject.setRoutineList(deleteExerciseDataAccessObject.read());
        routineList = deleteExerciseDataAccessObject.getRoutineList();
    }

    //bug in the read() method- not fixed
    @Test
    void existsByNameTest() {
        assertTrue(deleteExerciseDataAccessObject.existsByName("test1"));
        assertFalse(deleteExerciseDataAccessObject.existsByName("test5"));
    }

    // hitting monthly limit issue
    @Test
    void existsByIdTest() {
        assertTrue(deleteExerciseDataAccessObject.existsById("test2", "bear crawl"));
        assertFalse(deleteExerciseDataAccessObject.existsById("test1", "non-existent exercise"));
    }


    //implement interactor to use nullpointer
    @Test
    void deleteExerciseTest() {
        Routine r = routineList.get("test2");
        int previous = r.getExercisesList().size();
        deleteExerciseDataAccessObject.deleteExercise("test2", "bear crawl");
        int curr = r.getExercisesList().size();
        assertTrue(previous - 1 == curr);

        //re-add exercise bear crawl into routine test2 so future tests work
        ArrayList<String> instr = new ArrayList<>();
        instr.add("\"Start on all fours with your hands directly under your shoulders and your knees directly under your hips.\"");
        instr.add("\"Lift your knees slightly off the ground");
        instr.add(" keeping your back flat and your core engaged.\"");
        instr.add("Move your right hand and left foot forward simultaneously");
        instr.add(" followed by your left hand and right foot.\"");
        instr.add("\"Continue crawling forward");
        instr.add(" alternating your hand and foot movements.\"");
        instr.add("\"Maintain a steady pace and keep your core tight throughout the exercise.\"");
        instr.add("\"Continue for the desired distance or time.\"");
        ArrayList<Exercise> put_back  = new ArrayList<>();
        Exercise e = ExerciseFactory.create("bear crawl", "cardiovascular system", "body weight", instr, "3360", 0, 0);
        put_back.add(e);
        deleteExerciseDataAccessObject.addExercise("test2", put_back);

    }

    @Test
    void getRoutineTest() {
        assertEquals(deleteExerciseDataAccessObject.getRoutine("test1"), routineList.get("test1"));
        assertEquals(deleteExerciseDataAccessObject.getRoutine("nonexistent routine"), null);
    }

}