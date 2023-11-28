package data_access;

import entity.Exercise;
import entity.Routine;
import use_case.adjust_setrep;
import java.util.ArrayList;
import java.util.HashMap;

public class AdjustSetRepDataAccessObject implements AdjustSetRepDataAccessInterface {
    private HashMap<String, Routine> routineList;

    public AdjustSetRepDataAccessObject(HashMap<String, Routine> routineList) {
        this.routineList = routineList;
    }
    @Override
    public boolean existsByName(String identifier) {
        return routineList.containsKey(identifier);
    }

    @Override
    public void updateRoutine(String identifier, ArrayList<Integer> sets, ArrayList<Integer> reps) {
        Routine routine = routineList.get(identifier);
        ArrayList<Exercise> exercises = routine.getExercisesList();

        // Precondition: routine.getExercisesList().size() == sets.size() == reps.size()
        for (int i = 0; i < routine.getExercisesList().size(); i++) {
            exercises.get(i).setSets(sets.get(i));
            exercises.get(i).setReps(reps.get(i));
        }
        routine.setExercisesList(exercises);
        routineList.put(identifier, routine);
    }
}
