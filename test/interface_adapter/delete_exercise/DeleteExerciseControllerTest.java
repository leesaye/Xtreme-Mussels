package interface_adapter.delete_exercise;

import interface_adapter.delete_exercise.DeleteExerciseController;
import org.junit.jupiter.api.Test;
import use_case.delete_exercise.DeleteExerciseInputBoundary;
import use_case.delete_exercise.DeleteExerciseInputData;

import static org.junit.jupiter.api.Assertions.*;

class DeleteExerciseControllerTest {
    @Test
    void execute() {

        DeleteExerciseInputBoundary deleteInteractor = new DeleteExerciseInputBoundary() {
            @Override
            public void execute(DeleteExerciseInputData deleteExerciseInputData) {
                assertEquals("test1", deleteExerciseInputData.getRoutineName());
                assertEquals("bear crawl", deleteExerciseInputData.getExerciseName());
            }
        };

        DeleteExerciseController controller = new DeleteExerciseController(deleteInteractor);
        controller.execute("test1", "bear crawl");
    }

}