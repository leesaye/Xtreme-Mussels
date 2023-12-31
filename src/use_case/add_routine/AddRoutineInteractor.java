package use_case.add_routine;

import entity.RoutineFactory;
import entity.Routine;

import java.util.ArrayList;


public class AddRoutineInteractor implements AddRoutineInputBoundary {
    final AddRoutineOutputBoundary addRoutinePresenter;
    final AddRoutineDataAccessInterface addRoutineDataAccessObject;
    final RoutineFactory routineFactory;


    public AddRoutineInteractor(AddRoutineDataAccessInterface addRoutineDataAccessObject,
                                AddRoutineOutputBoundary addRoutineOutputBoundary, RoutineFactory routineFactory) {
        this.addRoutineDataAccessObject = addRoutineDataAccessObject;
        this.addRoutinePresenter = addRoutineOutputBoundary;
        this.routineFactory = routineFactory;
    }


    @Override
    public void execute(AddRoutineInputData addRoutineInputData) {
        if (addRoutineDataAccessObject.existsByName(addRoutineInputData.getRoutineName())) {
            addRoutinePresenter.prepareFailView("Routine name already exists.");
        } else {
            Routine routine = RoutineFactory.create(addRoutineInputData.getRoutineName());
            addRoutineDataAccessObject.addRoutine(routine);

            AddRoutineOutputData addRoutineOutputData = new AddRoutineOutputData(routine.getRoutineName(), false, addRoutineDataAccessObject.getRoutines());
            addRoutinePresenter.prepareSuccessView(addRoutineOutputData);
        }
    }
}