package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import use_case.add_exercise.AddExerciseDataAccessInterface;
import use_case.add_routine.AddRoutineDataAccessInterface;
import use_case.delete_exercise.DeleteExerciseDataAccessInterface;
import use_case.generate_routine.GenerateRoutineDataAccessInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static data_access.ApiDataAccessObject.getApi;

public class RoutineDataAccessObject implements AddExerciseDataAccessInterface, AddRoutineDataAccessInterface, AdjustSetRepDataAccessInterface, DeleteExerciseDataAccessInterface, GenerateRoutineDataAccessInterface {
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
            System.out.println(json);
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
     * The following are methods written for data access objects
     *
     */


    // For AdjustSetRepDataAccessInterface
    @Override
    public boolean existsByName(String identifier) {
        return routineList.containsKey(identifier);
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

    // For AddRoutineDataAccessInterface
    @Override
    public void addRoutine(Routine routine) {
        routineList.put(routine.getName(), routine);
    }

    // For GenerateRoutineDataAccessInterface
    @Override
    public void generateRoutine(Routine routine) {
        routineList.put(routine.getName(), routine);
    }
}
