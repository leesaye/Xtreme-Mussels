package interface_adapter.lookup;

import entity.Exercise;
import entity.ExerciseFactory;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import use_case.lookup.LookUpOutputBoundary;
import use_case.lookup.LookUpOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookUpPresenterTest {
    ArrayList<Exercise> exercises = new ArrayList<>();

    @BeforeEach
    void init () {
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("test instructions");
        exercises.add(ExerciseFactory.create("test name", "test target", "test equipment", instructions, "test id", 1, 2));
    }

    @Test
    void prepareSuccessTest() {
        LookUpViewModel lookUpViewModel = new LookUpViewModel("look up exercise") {
            private LookUpState state = new LookUpState();

            public LookUpState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals(exercises.get(0).getName(), state.getExercises().get(0).getName());
                assertEquals(state.getExercisesDisplay()[0][0], "test name");
                assertEquals(state.getExercisesDisplay()[0][2], "test equipment");
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LookUpOutputBoundary presenter = new LookUpPresenter(viewManagerModel, lookUpViewModel);

        presenter.prepareSuccessView(new LookUpOutputData(exercises, false));
    }

    @Test
    void prepareFailView() {
        LookUpViewModel lookUpViewModel = new LookUpViewModel("look up exercise") {
            private LookUpState state = new LookUpState();

            public LookUpState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals("look up fail", state.getExercisesError());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LookUpOutputBoundary presenter = new LookUpPresenter(viewManagerModel, lookUpViewModel);

        presenter.prepareFailView("look up fail");
    }
}
