package interface_adapter.add_routine;

import use_case.add_routine.AddRoutineInputBoundary;
import use_case.add_routine.AddRoutineInputData;

public class AddRoutineController {

    final AddRoutineInputBoundary addRoutineUseCaseInteractor;
    public AddRoutineController(AddRoutineInputBoundary addRoutineUseCaseInteractor) {
        this.addRoutineUseCaseInteractor = addRoutineUseCaseInteractor;
    }

    public void execute() {
        AddRoutineInputData addRoutineInputData = new AddRoutineInputData(
        );

        // AddRoutineUseCaseInteractor.execute(AddRoutineInputData);
    }
}