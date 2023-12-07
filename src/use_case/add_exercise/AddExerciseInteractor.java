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

        // Check routine with id corresponding to id exists
        if (!addExerciseDataAccessObject.existsByName(routineName)) {
            //Use exceptions? instead
            addExercisePresenter.prepareFailView("Selected routine does not exist");
        } else {
            // Check exercise with name corresponding to exercise_name exists
            try{
                ArrayList<Exercise> exerciseToAdd = addExerciseDataAccessObject.getExercisesByName(exerciseName, 1);
                // Update the routine named routine_name by adding the exercise entity corresponding to exercise_name
                addExerciseDataAccessObject.addExercise(routineName, exerciseToAdd);
                addExercisePresenter.prepareSuccessView(new AddExerciseOutputData(routineName, exerciseToAdd.get(0).getName(), addExerciseDataAccessObject.getRoutine(routineName)));
            }
            catch(RuntimeException e){
                addExercisePresenter.prepareFailView("Selected exercise does not exist");
            }
        }

    }
}
