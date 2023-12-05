package interface_adapter.add_routine;

import org.junit.jupiter.api.Test;
import use_case.add_routine.AddRoutineInputBoundary;
import use_case.add_routine.AddRoutineInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddRoutineControllerTest {

    // TODO: Test this!
    @Test
    void test() {
        AddRoutineInputBoundary addRoutineInteractor = new AddRoutineInputBoundary() {

            @Override
            public void execute(AddRoutineInputData addRoutineInputData) {
                assertEquals("routine1", addRoutineInputData.getRoutineName());
            }
        };

        AddRoutineController addRoutineController = new AddRoutineController(addRoutineInteractor);

        addRoutineController.execute("routine1");
    }
}