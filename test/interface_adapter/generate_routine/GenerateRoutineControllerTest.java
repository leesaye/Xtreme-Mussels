package interface_adapter.generate_routine;

import interface_adapter.generate_routine.GenerateRoutineController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.generate_routine.GenerateRoutineInputBoundary;
import use_case.generate_routine.GenerateRoutineInputData;

import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateRoutineControllerTest {
    // TODO: do i need this?
    @BeforeEach
    void init() {

    }
    @Test
    void test() {
        String name = "routine 1";
        String target = "arms";
        int number = 5;
        GenerateRoutineInputBoundary interactor = new GenerateRoutineInputBoundary() {
            @Override
            public void execute(GenerateRoutineInputData generateRoutineInputData) {
                assertEquals(name, generateRoutineInputData.getName());
                assertEquals(target, generateRoutineInputData.getTargetBodyPart());
                assertEquals(number,generateRoutineInputData.getNumberOfExercises());
            }
        };
        GenerateRoutineController controller = new GenerateRoutineController(interactor);

        controller.execute(target, number, name);
    }
}

