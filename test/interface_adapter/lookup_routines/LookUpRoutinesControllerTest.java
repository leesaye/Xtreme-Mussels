package interface_adapter.lookup_routines;

import org.junit.jupiter.api.Test;
import use_case.lookup_routines.LookUpRoutinesInputBoundary;


public class LookUpRoutinesControllerTest {

    @Test
    void test() {
        LookUpRoutinesInputBoundary interactor = new LookUpRoutinesInputBoundary() {

            @Override
            public void execute() {
                // No input data to test, this file may be removable
            }
        };
        LookUpRoutinesController controller = new LookUpRoutinesController(interactor);
        controller.execute();
    }
}
