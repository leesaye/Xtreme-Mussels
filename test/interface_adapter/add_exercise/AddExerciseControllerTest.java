package interface_adapter.add_exercise;

import org.junit.jupiter.api.Test;
import use_case.add_exercise.AddExerciseInputBoundary;
import use_case.add_exercise.AddExerciseInputData;

import static org.junit.jupiter.api.Assertions.*;

class AddExerciseControllerTest {

    @Test
    void execute() {

        AddExerciseInputBoundary addInteractor = new AddExerciseInputBoundary() {
            @Override
            public void execute(AddExerciseInputData addExerciseInputData) {
                assertEquals("test1", addExerciseInputData.getRoutineName());
                assertEquals("bear crawl", addExerciseInputData.getExerciseName());
            }
        };

        AddExerciseController controller = new AddExerciseController(addInteractor);
        controller.execute("test1", "bear crawl");
    }
}