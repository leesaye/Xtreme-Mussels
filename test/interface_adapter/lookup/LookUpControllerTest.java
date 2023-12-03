package interface_adapter.lookup;

import org.junit.jupiter.api.Test;
import use_case.lookup.LookUpInputBoundary;
import use_case.lookup.LookUpInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookUpControllerTest {
    @Test
    void testTarget() {
        LookUpInputBoundary interactor = new LookUpInputBoundary() {

            @Override
            public void execute(LookUpInputData lookUpInputData) {
                assertEquals(lookUpInputData.getValue(), "hamstrings");
                assertEquals(lookUpInputData.getQuery(), "target");
            }
        };

        LookUpController controller = new LookUpController(interactor);
        controller.execute("hamstrings", "target");
    }

    @Test
    void testName() {
        LookUpInputBoundary interactor = new LookUpInputBoundary() {

            @Override
            public void execute(LookUpInputData lookUpInputData) {
                assertEquals(lookUpInputData.getValue(), "plank");
                assertEquals(lookUpInputData.getQuery(), "name");
            }
        };

        LookUpController controller = new LookUpController(interactor);
        controller.execute("plank", "name");
    }
}
