package interface_adapter.lookup_routine;

import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import entity.RoutineFactory;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.lookup_routine.LookUpRoutineOutputBoundary;
import use_case.lookup_routine.LookUpRoutineOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookUpRoutinePresenterTest {
    Routine routine;

    @BeforeEach
    void init () {
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("test instructions");
        ArrayList<Exercise> exercises = new ArrayList<>();
        exercises.add(ExerciseFactory.create("test name", "test target", "test equipment", instructions, "test id", 1, 2));
        routine = RoutineFactory.create("routine test");
        routine.setExercisesList(exercises);
    }

    @Test
    void prepareSuccessTest() {
        LookUpRoutineViewModel lookUpRoutineViewModel = new LookUpRoutineViewModel("look up routine") {
            private LookUpRoutineState state = new LookUpRoutineState();

            public LookUpRoutineState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals(state.getRoutine().getRoutineName(), "routine test");
                assertEquals(state.getRoutine().getExercisesList().get(0).getName(), "test name");
                assertEquals(state.getExercisesDisplay()[0][0], "test name");
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LookUpRoutineOutputBoundary presenter = new LookUpRoutinePresenter(viewManagerModel, lookUpRoutineViewModel);

        presenter.prepareSuccessView(new LookUpRoutineOutputData(routine, false));
    }

    @Test
    void prepareFailView() {
        LookUpRoutineViewModel lookUpRoutineViewModel = new LookUpRoutineViewModel("look up routine") {
            private LookUpRoutineState state = new LookUpRoutineState();

            public LookUpRoutineState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals("look up routine fail", state.getRoutineError());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LookUpRoutineOutputBoundary presenter = new LookUpRoutinePresenter(viewManagerModel, lookUpRoutineViewModel);

        presenter.prepareFailView("look up routine fail");
    }
}
