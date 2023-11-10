package use_case.edit_routine;

import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class EditRoutineInteractor implements EditRoutineInputBoundary {
    final EditRoutineDataAccessInterface editDataAccessObject;

    final EditRoutineOutputBoundary editPresenter;

    public EditRoutineInteractor(EditRoutineDataAccessInterface editDataAccessObject,
                                 EditRoutineOutputBoundary editRoutineOutputBoundary) {
        this.editDataAccessObject = editDataAccessObject;
        this.editPresenter = editRoutineOutputBoundary;
    }


    @Override
    public void execute(EditRoutineInputData editInputData) {
        String name = editInputData.getName();
        int id = editInputData.getId();

        // check the given id actually exists (it should exist since it's generated for user)
        if (!editDataAccessObject.existsById(id)) {
            editPresenter.prepareFailView(name + ": Routine does not exist");
        } else {
            // Update the routine with the new name and exercises/sets
            editDataAccessObject.updateRoutine(id, name, editInputData.getExercises(),
                    editInputData.getReps(), editInputData.getSets());
            editPresenter.prepareSuccessView(new EditRoutineOutputData(name));
        }
    }
}
