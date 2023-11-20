package interface_adapter.adjust_setrep;

import use_case.adjust_setrep.AdjustSetRepInputBoundary;
import entity.Exercise;
import use_case.adjust_setrep.AdjustSetRepInputData;

import java.util.ArrayList;

public class AdjustSetRepController {

    final AdjustSetRepInputBoundary adjustUseCaseInteractor;

    public AdjustSetRepController(AdjustSetRepInputBoundary adjustUseCaseInteractor) {
        this.adjustUseCaseInteractor = adjustUseCaseInteractor;
    }

    public void execute(int id, ArrayList<Exercise> exercises) {
        AdjustSetRepInputData adjustInputData = new AdjustSetRepInputData(id, exercises);

        adjustUseCaseInteractor.execute(adjustInputData);
    }
}
