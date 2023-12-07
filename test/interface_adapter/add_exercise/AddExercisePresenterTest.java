package interface_adapter.add_exercise;

import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.add_exercise.AddExerciseOutputBoundary;
import use_case.add_exercise.AddExerciseOutputData;

import static org.junit.jupiter.api.Assertions.*;

class AddExercisePresenterTest {

    @Test
    void prepareSuccessViewTest() {

        AddExerciseViewModel addView = new AddExerciseViewModel() {
            private AddExerciseState state = new AddExerciseState();

            public AddExerciseState getState() {return state;}

            public void firePropertyChanged() {
                assertEquals("r1", state.getRoutineName());
                String[][] expected = {{"bear crawl"}};
                assertEquals(expected[0][0], state.getExercisesDisplay()[0][0]);
            }
        };

        ViewManagerModel viewManager = new ViewManagerModel();
        AddExerciseOutputBoundary presenter = new AddExercisePresenter(viewManager, addView);

        Routine routine = new Routine("r1");
        routine.setName("r1");
        Exercise bc = ExerciseFactory.create("bear crawl", "cardiovascular systen", "bpdy weight", null, "3360", 3, 15);
        routine.getExercisesList().add(bc);

        presenter.prepareSuccessView(new AddExerciseOutputData("r1", "bear crawl", routine));
    }

    @Test
    void prepareFailViewTest() {
        AddExerciseViewModel addViewModel = new AddExerciseViewModel() {
            private AddExerciseState state = new AddExerciseState();

            public AddExerciseState getState() { return state; }

            public void firePropertyChanged() {
                assertEquals("nonexistent", state.getRoutineNameError());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        AddExerciseOutputBoundary presenter = new AddExercisePresenter(viewManagerModel, addViewModel);

        presenter.prepareFailView("nonexistent");
    }

}