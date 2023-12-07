package interface_adapter.delete_routine;

import org.junit.jupiter.api.Test;
import use_case.delete_routine.DeleteRoutineInputBoundary;
import use_case.delete_routine.DeleteRoutineInputData;

import static org.junit.jupiter.api.Assertions.*;

class DeleteRoutineControllerTest {

    @Test
    void execute() {
        DeleteRoutineInputBoundary deleteInteractor = new DeleteRoutineInputBoundary() {
            @Override
            public void execute(DeleteRoutineInputData deleteRoutineInputData) {
                assertEquals("test1", deleteRoutineInputData.getRoutineName());
            }
        };

        DeleteRoutineController controller = new DeleteRoutineController(deleteInteractor);
        controller.execute("test1");
    }
}