package use_case.lookup;

import entity.Exercise;

import java.util.ArrayList;

public class LookUpInteractor implements LookUpInputBoundary {
    final LookUpDataAccessInterface exerciseDataAccessObject;
    final LookUpOutputBoundary exercisePresenter;

    public LookUpInteractor(LookUpDataAccessInterface exerciseDataAccessObject, LookUpOutputBoundary exercisePresenter) {
        this.exerciseDataAccessObject = exerciseDataAccessObject;
        this.exercisePresenter = exercisePresenter;
    }

    @Override
    public void execute(LookUpInputData lookUpInputData) {
        ArrayList<Exercise> exercises;
        if (lookUpInputData.getQuery().equals("target")) {
            exercises = exerciseDataAccessObject.getExercises("target");
        } else if (lookUpInputData.getQuery().equals("name")) {
            exercises = exerciseDataAccessObject.getExercises("name");
        } else {
            exercisePresenter.prepareFailView("Invalid query option.");
            return;
        }
        LookUpOutputData lookUpOutputData = new LookUpOutputData(exercises, false);
        exercisePresenter.prepareSuccessView(lookUpOutputData);
    }
}
