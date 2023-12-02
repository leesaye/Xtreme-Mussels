package interface_adapter.generate_routine;

import use_case.generate_routine.GenerateRoutineOutputBoundary;
import use_case.generate_routine.GenerateRoutineOutputData;
import view.ViewManager;

public class GenerateRoutinePresenter implements GenerateRoutineOutputBoundary {

    private final GenerateRoutineViewModel generateRoutineViewModel;
    private GenerateRoutineController generateRoutineController;
//    TODO: uncomment this once pulled all the changes from Git
//    private ViewManagerModel viewManager;

    public GenerateRoutinePresenter(GenerateRoutineViewModel generateRoutineViewModel
//            , ViewManagerModel viewManager
    ) {
        this.generateRoutineViewModel = generateRoutineViewModel;
//        this.viewManager = viewManager;
    }
    @Override
    public void prepareSuccessView(GenerateRoutineOutputData generateRoutineOutputData) {
        GenerateRoutineState generateRoutineState = generateRoutineViewModel.getGenerateRoutineState();
        generateRoutineState.setRoutineList(generateRoutineOutputData.getListOfExercises());
        generateRoutineState.setRoutineName(generateRoutineOutputData.getName());
        generateRoutineState.setReps(generateRoutineOutputData.getReps());
        generateRoutineState.setSets(generateRoutineOutputData.getSets());
//        this.generateRoutineViewModel.setGenerateRoutineState(generateRoutineState);
        generateRoutineViewModel.firePropertyChanged();


    }

    @Override
    public void prepareFailedView(String message) {
        GenerateRoutineState generateRoutineState = generateRoutineViewModel.getGenerateRoutineState();
        generateRoutineState.setErrorMessage(message);
        generateRoutineViewModel.firePropertyChanged(); // TODO: need to implement this!!
    }

}
