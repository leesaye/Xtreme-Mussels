package interface_adapter.generate_routine;

import entity.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.generate_routine.GenerateRoutineOutputBoundary;
import use_case.generate_routine.GenerateRoutineOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateRoutinePresenterTest {
    ArrayList<Exercise> exercises = new ArrayList<>();
    ArrayList<String> instructions = new ArrayList<>();
    Exercise bicep_curls = new Exercise("bicep_curls", "arms", "dumbbells", instructions, "22", 3, 5);

    @BeforeEach
    void init() {
        instructions.add("do this");
        instructions.add("step 2");
        exercises.add(bicep_curls);
    }
    @Test
    void prepareSuccessViewTest() {
        String name = "routine 1";
        int sets = 4;
        int reps = 12;

        GenerateRoutineViewModel generateRoutineViewModel = new GenerateRoutineViewModel() {
            private GenerateRoutineState state = new GenerateRoutineState();

            public GenerateRoutineState getGenerateRoutineState() {
                return state;
            }

            @Override
            public void firePropertyChange() {
                assertEquals(exercises, state.getRoutineList());
                assertEquals(name, state.getRoutineName());
                int sets_test = state.getSets();
                assertTrue(1 <= sets_test && sets_test <=5);
                int reps_test = state.getReps();
                assertTrue(10 <= reps_test && reps_test <= 20);
            }
        };
        GenerateRoutineOutputBoundary present = new GenerateRoutinePresenter(generateRoutineViewModel);
        present.prepareSuccessView(new GenerateRoutineOutputData(exercises, name, sets, reps));
    }

    @Test
    void prepareFailedViewTest() {

        GenerateRoutineViewModel generateRoutineViewModel = new GenerateRoutineViewModel(){
            private GenerateRoutineState state = new GenerateRoutineState();

            public GenerateRoutineState getGenerateRoutineState() {
                return state;
            }
            @Override
            public void firePropertyChange() {
                assertEquals("Error", state.getErrorMessage());

            }
        };
        GenerateRoutineOutputBoundary present = new GenerateRoutinePresenter(generateRoutineViewModel);
        present.prepareFailedView("Error");

    }
}
