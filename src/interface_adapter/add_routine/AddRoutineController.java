package interface_adapter.add_routine;

import use_case.add_routine.AddRoutineInputBoundary;

public class AddRoutineController {

    final AddRoutineInputBoundary addRoutineUseCaseInteractor;
    public AddRoutineController(AddRoutineInputBoundary addRoutineUseCaseInteractor) {
        this.addRoutineUseCaseInteractor = addRoutineUseCaseInteractor;
    }
}