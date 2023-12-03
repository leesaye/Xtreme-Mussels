package interface_adapter.lookup_routine;

import org.junit.jupiter.api.Test;
import use_case.lookup_routine.LookUpRoutineInputBoundary;
import use_case.lookup_routine.LookUpRoutineInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookUpRoutineControllerTest {
    @Test
    void test() {
        LookUpRoutineInputBoundary interactor = new LookUpRoutineInputBoundary() {

            @Override
            public void execute(LookUpRoutineInputData lookUpRoutineInputData) {
                assertEquals(lookUpRoutineInputData.getRoutineName(), "routine name test");
            }
        };
        LookUpRoutineController controller = new LookUpRoutineController(interactor);
        controller.execute("routine name test");
    }
}
