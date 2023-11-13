package use_case.add_routine;

public class AddRoutineInteractor implements AddRoutineInputBoundary{

    final AddRoutineUserDataAccessInterface addRoutineUserDataAccessInterface;
    final AddRoutineOutputBoundary addRoutinePresenter;
    public AddRoutineInteractor(AddRoutineUserDataAccessInterface addRoutineUserDataAccessInterface,
                                AddRoutineOutputBoundary addRoutineOutputBoundary) {
        this.addRoutineUserDataAccessInterface = addRoutineUserDataAccessInterface;
        this.addRoutinePresenter = addRoutineOutputBoundary;
    }

    @Override
    public void execute(AddRoutineInputData addRoutineInputData) {

    }
}