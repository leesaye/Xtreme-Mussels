package interface_adapter.add_routine;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.add_routine.AddRoutineOutputBoundary;
import use_case.add_routine.AddRoutineOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddRoutinePresenterTest {
    @Test
    void prepareSuccessTest() {
        AddRoutineViewModel addRoutineViewModel = new AddRoutineViewModel() {
            private AddRoutineState state = new AddRoutineState();

            public AddRoutineState getState() {
                return state;
            }

            public void firePropertyChanged() {
                assertEquals("routine1", state.getRoutineName());
            }
        };

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        AddRoutineOutputBoundary addRoutinePresenter = new AddRoutinePresenter(viewManagerModel, addRoutineViewModel);
        addRoutinePresenter.prepareSuccessView(new AddRoutineOutputData("routine1", false, null));
    }

    @Test
    void prepareFailTest() {
        AddRoutineViewModel addRoutineViewModel = new AddRoutineViewModel() {
            private AddRoutineState state = new AddRoutineState();public AddRoutineState getState() {
                return state;
            }
            public void firePropertyChanged() {
                    assertEquals("add routine error", state.getRoutineNameError());
                }
            };

            ViewManagerModel viewManagerModel = new ViewManagerModel();
            AddRoutineOutputBoundary addRoutinePresenter = new AddRoutinePresenter(viewManagerModel, addRoutineViewModel);

            addRoutinePresenter.prepareFailView("add routine error");
        }
    }