package interface_adapter.lookup;
import entity.Exercise;
import interface_adapter.ViewManagerModel;
import use_case.lookup.LookUpOutputBoundary;
import use_case.lookup.LookUpOutputData;

import java.util.ArrayList;

public class LookUpPresenter implements LookUpOutputBoundary {
    private final LookUpViewModel lookUpViewModel;
    private ViewManagerModel viewManagerModel;

    public LookUpPresenter(ViewManagerModel viewManagerModel, LookUpViewModel lookUpViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.lookUpViewModel = lookUpViewModel;
    }

    @Override
    public void prepareSuccessView(LookUpOutputData response) {
        LookUpState lookUpState = lookUpViewModel.getState();
        ArrayList<Exercise> exercises = response.getExercises();
        lookUpState.setExercises(exercises);
        lookUpState.setExercisesDisplay(exercises);
        lookUpViewModel.setState(lookUpState);
        this.lookUpViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LookUpState lookUpState = lookUpViewModel.getState();
        lookUpState.setExercisesError(error);
        lookUpViewModel.setState(lookUpState);
        lookUpViewModel.firePropertyChanged();
    }
}
