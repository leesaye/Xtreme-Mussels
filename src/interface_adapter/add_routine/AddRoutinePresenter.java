package interface_adapter.add_routine;

import use_case.add_routine.AddRoutineOutputBoundary;
import use_case.add_routine.AddRoutineOutputData;

public class AddRoutinePresenter implements AddRoutineOutputBoundary {
    private final AddRoutineViewModel addRoutineViewModel;

    public AddRoutinePresenter(AddRoutineViewModel addRoutineViewModel) {
        this.addRoutineViewModel = addRoutineViewModel;
    }

    @Override
    public void prepareSuccessView(AddRoutineOutputData addRoutineOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
