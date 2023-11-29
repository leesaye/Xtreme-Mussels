package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Exercise;
import entity.Routine;
import use_case.add_exercise.AddExerciseDataAccessInterface;
import use_case.add_routine.AddRoutineDataAccessInterface;
import use_case.delete_exercise.DeleteExerciseDataAccessInterface;
import use_case.generate_routine.GenerateRoutineDataAccessInterface;
import use_case.lookup_routine.LookUpRoutineDataAccessInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RoutineDataAccessObject implements AddExerciseDataAccessInterface, AddRoutineDataAccessInterface, AdjustSetRepDataAccessInterface, DeleteExerciseDataAccessInterface, GenerateRoutineDataAccessInterface, LookUpRoutineDataAccessInterface {
    private Routine routine;
    private HashMap<String, Routine> routineList;
    private String path;

    public RoutineDataAccessObject(Routine routine, HashMap<String, Routine> routineList, String path) {
        this.routine = routine;
        this.routineList = routineList;
        this.path = path;
    }

    public void save() {
        this.save(routineList, path);
    }

    // Writes all routines to json (save method)
    private void save(HashMap<String, Routine> routineList, String path) {
        try {
            final StringWriter sw = new StringWriter();
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(sw, routineList);
            String json = sw.toString();
            sw.close();

            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * The following are methods written for specific use cases
     *
     */


    // For AdjustSetRepDataAccessInterface, name is the routine name
    @Override
    public boolean existsByName(String identifier) {
        return routineList.containsKey(identifier);
    }

    // For AddExerciseDataAccessInterface (id is the id of the exercise, identifier is routine identifier/name)
    @Override
    public boolean existsById(String identifier, String id) {
        ArrayList<Exercise> exercises = routineList.get(identifier).getExercisesList();

        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // For AdjustSetRepDataAccessInterface
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

    // For AddRoutineDataAccessInterface and GenerateRoutineDataAccessInterface
    @Override
    public void addRoutine(Routine routine) {
        routineList.put(routine.getName(), routine);
    }

    // For AddExerciseDataAccessInterface, assumes exercises is of length 1
    @Override
    public void addExercise(String identifier, ArrayList<Exercise> exercises) {
        ArrayList<Exercise> currExercises = routineList.get(identifier).getExercisesList();
        currExercises.add(exercises.get(0));
        routineList.get(identifier).setExercisesList(currExercises);
    }

    // For DeleteExerciseDataAccessInterface
    @Override
    public void deleteExercise(String identifier, String exerciseName) {
        ArrayList<Exercise> exercises = routineList.get(identifier).getExercisesList();
        int index = 0;
        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getName().equals(exerciseName)) {
                index = i;
                break;
            }
        }
        exercises.remove(index);
        routineList.get(identifier).setExercisesList(exercises);
    }

    // For LookUpRoutineDataAccessInterface
    public Routine getRoutine(String name) {
        return routineList.get(name);
    }
}
