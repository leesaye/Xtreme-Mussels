package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate_routine.GenerateRoutineController;
import interface_adapter.generate_routine.GenerateRoutinePresenter;
import interface_adapter.generate_routine.GenerateRoutineViewModel;
import use_case.generate_routine.GenerateRoutineDataAccessInterface;
import use_case.generate_routine.GenerateRoutineInputBoundary;
import use_case.generate_routine.GenerateRoutineInteractor;
import use_case.generate_routine.GenerateRoutineOutputBoundary;
import view.GenerateRoutineView;

import javax.swing.*;
import java.io.IOException;

public class GenerateRoutineUseCaseFactory {
    private GenerateRoutineUseCaseFactory() {}

    public static GenerateRoutineView create(ViewManagerModel viewManagerModel, GenerateRoutineViewModel generateRoutineViewModel, GenerateRoutineDataAccessInterface dataAccessInterface) {
        try {
            GenerateRoutineController generateRoutineController = createGenerateRoutineCase(viewManagerModel, generateRoutineViewModel, dataAccessInterface);
            return new GenerateRoutineView(generateRoutineController, generateRoutineViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not");
        }

        return null;

    }

    private static GenerateRoutineController createGenerateRoutineCase(
            ViewManagerModel viewManagerModel,
            GenerateRoutineViewModel generateRoutineViewModel,
            GenerateRoutineDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        GenerateRoutineOutputBoundary generateRoutineOutputBoundary = new GenerateRoutinePresenter(generateRoutineViewModel, viewManagerModel);


        GenerateRoutineInputBoundary generateRoutineInteractor = new GenerateRoutineInteractor(
                userDataAccessObject, generateRoutineOutputBoundary);

        return new GenerateRoutineController(generateRoutineInteractor);
    }
}
