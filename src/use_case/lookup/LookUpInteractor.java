package use_case.lookup;

import entity.Exercise;

import java.util.ArrayList;
import java.util.Objects;

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
            exercises = exerciseDataAccessObject.getExercisesByQuery(lookUpInputData.getValue(),"target");
        } else if (lookUpInputData.getQuery().equals("name")) {
            exercises = exerciseDataAccessObject.getExercisesByQuery(lookUpInputData.getValue(),"name");
            if (exercises.isEmpty()) {
                exercisePresenter.prepareFailView("No exercises found.");
                return;
            }
        } else {
            exercisePresenter.prepareFailView("Invalid query option.");
            return;
        }
        LookUpOutputData lookUpOutputData = new LookUpOutputData(exercises, false);
        exercisePresenter.prepareSuccessView(lookUpOutputData);
    }
}
