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
        String routine_name = addExerciseInputData.getRoutineName();
        String exercise_name = addExerciseInputData.getExerciseName();

        // Check routine with id corresponding to id exists
        if (!addExerciseDataAccessObject.existsByName(routine_name)) {
            //Use exceptions? instead
            addExercisePresenter.prepareFailView("Routine" + routine_name + "does not exist");
        } else {
            // Check exercise with name corresponding to exercise_name exists
            try{
                ArrayList<Exercise> exercise_to_add = addExerciseDataAccessObject.getExercisesByName(exercise_name, 1);
                // Update the routine named routine_name by adding the exercise entity corresponding to exercise_name
                addExerciseDataAccessObject.addExercise(routine_name, exercise_to_add);
                addExercisePresenter.prepareSuccessView(new AddExerciseOutputData(routine_name, exercise_name));
            }
            catch(RuntimeException e){
                addExercisePresenter.prepareFailView("Exercise" + exercise_name + "does not exist");
            }
        }

    }
}
