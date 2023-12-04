package interface_adapter.add_routine;

import use_case.add_routine.AddRoutineInputBoundary;
import use_case.add_routine.AddRoutineInputData;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executor;

public class AddRoutineController {

    final AddRoutineInputBoundary addRoutineUseCaseInteractor;
    public AddRoutineController(AddRoutineInputBoundary addRoutineUseCaseInteractor) {
        this.addRoutineUseCaseInteractor = addRoutineUseCaseInteractor;
    }

    public void execute(int id, String routineName, ArrayList<Map<String, Object>> exercisesList) {
        AddRoutineInputData addRoutineInputData = new AddRoutineInputData(routineName);

        addRoutineUseCaseInteractor.execute(addRoutineInputData);
    }
}