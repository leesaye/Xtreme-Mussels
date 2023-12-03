package interface_adapter.lookup_routines;

import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import entity.RoutineFactory;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.lookup_routines.LookUpRoutinesOutputBoundary;
import use_case.lookup_routines.LookUpRoutinesOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookUpRoutinesPresenterTest {
    ArrayList<Routine> routines;

    @BeforeEach
    void init () {
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("test instructions");
        ArrayList<Exercise> exercises = new ArrayList<>();
        exercises.add(ExerciseFactory.create("test name", "test target", "test equipment", instructions, "test id", 1, 2));
        Routine routine1 = RoutineFactory.create("routine1 test");
        routine1.setExercisesList(exercises);
        Routine routine2 = RoutineFactory.create("routine2 test");
        routine2.setExercisesList(exercises);
        routines.add(routine1);
        routines.add(routine2);
    }

    // NOTE: no fail view, will simply output "empty" success view when no routines
    @Test
    void prepareSuccessTest() {
        LookUpRoutinesViewModel lookUpRoutinesViewModel = new LookUpRoutinesViewModel("look up routines") {
            private LookUpRoutinesState state = new LookUpRoutinesState();

            public LookUpRoutinesState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals(state.getRoutines().size(), 3);
                assertEquals(state.getRoutines().get(0).getName(), "routine1 test");
                assertEquals(state.getRoutines().get(1).getName(), "routine2 test");
                assertEquals(state.getRoutines().get(1).getExercisesList().get(0), "test name");
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LookUpRoutinesOutputBoundary presenter = new LookUpRoutinesPresenter(viewManagerModel, lookUpRoutinesViewModel);

        presenter.prepareSuccessView(new LookUpRoutinesOutputData(routines));
    }
}
