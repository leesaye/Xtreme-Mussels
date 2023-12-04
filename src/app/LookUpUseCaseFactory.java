package app;

import interface_adapter.MainViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.lookup.LookUpController;
import interface_adapter.lookup.LookUpPresenter;
import interface_adapter.lookup.LookUpViewModel;
import use_case.lookup.LookUpDataAccessInterface;
import use_case.lookup.LookUpInputBoundary;
import use_case.lookup.LookUpInteractor;
import use_case.lookup.LookUpOutputBoundary;
import view.LookupView;
import view.MainView;

import javax.swing.*;
import java.io.IOException;

public class LookUpUseCaseFactory {
    private LookUpUseCaseFactory() {}
    private MainView mainView;
    public static LookupView create(ViewManagerModel viewManagerModel, LookUpViewModel lookUpViewModel, LookUpDataAccessInterface dataAccessInterface) {
        try {
            LookUpController lookUpController = createLookUpUseCase(viewManagerModel, lookUpViewModel, dataAccessInterface);
            return new LookupView(lookUpViewModel, lookUpController, viewManagerModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not");
        }

        return null;

    }

    private static LookUpController createLookUpUseCase(
            ViewManagerModel viewManagerModel,
            LookUpViewModel lookUpViewModel,
            LookUpDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        LookUpOutputBoundary lookUpOutputBoundary = new LookUpPresenter(viewManagerModel, lookUpViewModel);


        LookUpInputBoundary lookUpInteractor = new LookUpInteractor(
                userDataAccessObject, lookUpOutputBoundary);

        return new LookUpController(lookUpInteractor);
    }

}
