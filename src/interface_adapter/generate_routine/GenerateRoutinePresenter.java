package interface_adapter.generate_routine;

import use_case.generate_routine.GenerateRoutineOutputBoundary;
import use_case.generate_routine.GenerateRoutineOutputData;
import view.ViewManager;

public class GenerateRoutinePresenter implements GenerateRoutineOutputBoundary {

    private GenerateRoutineViewModel generateRoutineViewModel;
    private GenerateRoutineState generateRoutineState;
    private GenerateRoutineController generateRoutineController;
    private ViewManager viewManager;

    public GenerateRoutinePresenter(GenerateRoutineViewModel generateRoutineViewModel) {
        this.generateRoutineViewModel = generateRoutineViewModel;
    }
    @Override
    public void prepareSuccessView(GenerateRoutineOutputData generateRoutineOutputData) {
        GenerateRoutineState generateRoutineState = generateRoutineViewModel.getGenerateRoutineState();

    }

    @Override
    public void prepareFailedView(String message) {
        GenerateRoutineState generateRoutineState = generateRoutineViewModel.getGenerateRoutineState();
        generateRoutineState.setErrorMessage(message);
        // generateRoutineViewModel.firePropertyChanged() <- // TODO: need to implement this!!
    }

}
