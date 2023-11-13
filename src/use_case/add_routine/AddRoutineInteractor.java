package use_case.add_routine;

import entity.User;

public class AddRoutineInteractor implements AddRoutineInputBoundary{

    final AddRoutineUserDataAccessInterface addRoutineUserDataAccessInterface;
    final AddRoutineOutputBoundary addRoutinePresenter;

    public AddRoutineInteractor(AddRoutineUserDataAccessInterface addRoutineUserDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(AddRoutineInputData addRoutineInputData) {

    }
}