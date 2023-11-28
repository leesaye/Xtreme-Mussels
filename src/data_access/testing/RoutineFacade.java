package data_access;

import entity.Routine;
import use_case.add_exercise.AddExerciseDataAccessInterface;
import use_case.add_routine.AddRoutineDataAccessInterface;
import use_case.adjust_setrep.AdjustSetRepDataAccessInterface;
import use_case.delete_exercise.DeleteExerciseDataAccessInterface;
import use_case.generate_routine.GenerateRoutineDataAccessInterface;
import use_case.lookup.LookUpDataAccessInterface;

import java.io.File;
import java.util.HashMap;


public class RoutineFacade {
    private HashMap<String, Routine> routineList;
    private String path;
    private AddExerciseDataAccessInterface addExerciseDataAccessObject;
    private AddRoutineDataAccessInterface addRoutineDataAccessObject;
    private AdjustSetRepDataAccessInterface adjustSetRepDataAccessObject;
    private DeleteExerciseDataAccessInterface deleteExerciseDataAccessObject;
    private GenerateRoutineDataAccessInterface generateRoutineDataAccessObject;
    private LookUpDataAccessInterface lookUpDataAccessObject;

    public RoutineFacade (HashMap<String, Routine> routineList, String path,
                          AddExerciseDataAccessInterface addExerciseDataAccessObject,
                          AddRoutineDataAccessInterface addRoutineDataAccessObject,
                          AdjustSetRepDataAccessInterface adjustSetRepDataAccessObject,
                          DeleteExerciseDataAccessInterface deleteExerciseDataAccessObject,
                          GenerateRoutineDataAccessInterface generateRoutineDataAccessObject,
                          LookUpDataAccessInterface lookUpDataAccessObject) {

        this.routineList = routineList;
        this.path = path;
        this.addExerciseDataAccessObject = addExerciseDataAccessObject;
        this.addRoutineDataAccessObject = addRoutineDataAccessObject;
        this.adjustSetRepDataAccessObject = adjustSetRepDataAccessObject;
        this.deleteExerciseDataAccessObject = deleteExerciseDataAccessObject;
        this.generateRoutineDataAccessObject = generateRoutineDataAccessObject;
        this.lookUpDataAccessObject = lookUpDataAccessObject;
    }

    // Changes hashmap (and then it will save to the file)
    public void mutateMap() {}


    public void save() {

    }


}
