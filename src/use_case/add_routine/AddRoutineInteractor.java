package use_case.add_routine;

import entity.Routine;
import entity.RoutineFactory;

public class AddRoutineInteractor implements AddRoutineInputBoundary{
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
            Routine routine = routineFactory.create(addRoutineInputData.getRoutineName());
            addRoutineDataAccessObject.save(routine);

            AddRoutineOutputData addRoutineOutputData = new AddRoutineOutputData(routine.getRoutineName(), false);
            addRoutinePresenter.prepareSuccessView(addRoutineOutputData);
        }
    }
}