package use_case.add_exercise;


import entity.Exercise;

import java.util.ArrayList;

public class
AddExerciseInteractor implements AddExerciseInputBoundary{
    final AddExerciseDataAccessInterface addExerciseDataAccessObject;

    final AddExerciseOutputBoundary addExercisePresenter;

    public AddExerciseInteractor(AddExerciseDataAccessInterface addExerciseDataAccessObject,
                                 AddExerciseOutputBoundary addExerciseOutputBoundary) {
        this.addExerciseDataAccessObject = addExerciseDataAccessObject;
        this.addExercisePresenter = addExerciseOutputBoundary;
    }

    @Override
    public void execute(AddExerciseInputData addExerciseInputData) {
        String routineName = addExerciseInputData.getRoutineName();
        String exerciseName = addExerciseInputData.getExerciseName();
        ArrayList<Exercise> exerciseToAdd = addExerciseDataAccessObject.getExercisesByName(exerciseName, 1);


        // Check routine with id corresponding to id exists
        if (!addExerciseDataAccessObject.existsByName(routineName)) {
            addExercisePresenter.prepareFailView("Selected routine does not exist");
        } else if (exerciseToAdd.isEmpty()){
            addExercisePresenter.prepareFailView("Selected exercise does not exist");
        } else {
            addExerciseDataAccessObject.addExercise(routineName, exerciseToAdd);
            addExercisePresenter.prepareSuccessView(new AddExerciseOutputData(routineName, exerciseName, addExerciseDataAccessObject.getRoutine(routineName)));
        }
    }
}
