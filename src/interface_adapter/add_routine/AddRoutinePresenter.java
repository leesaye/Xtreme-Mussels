package interface_adapter.add_routine;

import use_case.add_routine.AddRoutineOutputBoundary;

public class AddRoutinePresenter implements AddRoutineOutputBoundary {
    private final AddRoutineViewModel addRoutineViewModel;

    public AddRoutinePresenter(AddRoutineViewModel addRoutineViewModel) {
        this.addRoutineViewModel = addRoutineViewModel;
    }
}
