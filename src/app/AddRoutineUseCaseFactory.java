package app;

import entity.UserFactory;
import interface_adapter.add_routine.AddRoutineController;
import interface_adapter.add_routine.AddRoutineViewModel;
import view.AddRoutineView;

import java.io.IOException;

public class AddRoutineUseCaseFactory {
    private AddRoutineUseCaseFactory() {}

    public static AddRoutineView create(
            AddRoutineViewModel addRoutineViewModel) {
        return null;
    }


    // private static AddRoutineController createAddRoutineUseCase(
    // AddRoutineViewModel addRoutineViewModel,

        // Notice how we pass this method's parameters to the Presenter.
    // LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);

    // UserFactory userFactory = new CommonUserFactory();

// LoginInputBoundary loginInteractor = new LoginInteractor(
// userDataAccessObject, loginOutputBoundary);

    // return new LoginController(loginInteractor);
}