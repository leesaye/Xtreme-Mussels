package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import entity.RoutineFactory;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import use_case.add_exercise.AddExerciseDataAccessInterface;
import use_case.add_routine.AddRoutineDataAccessInterface;
import use_case.delete_exercise.DeleteExerciseDataAccessInterface;
import use_case.generate_routine.GenerateRoutineDataAccessInterface;
import use_case.lookup_routine.LookUpRoutineDataAccessInterface;
import use_case.adjust_setrep.AdjustSetRepDataAccessInterface;
import use_case.rename_routine.RenameRoutineDataAccessInterface;
import use_case.lookup_routines.LookUpRoutinesDataAccessInterface;

import java.io.*;
import java.util.*;


public class RoutineDataAccessObject implements AddExerciseDataAccessInterface, AddRoutineDataAccessInterface, AdjustSetRepDataAccessInterface, DeleteExerciseDataAccessInterface,
        GenerateRoutineDataAccessInterface, LookUpRoutineDataAccessInterface, LookUpRoutinesDataAccessInterface, RenameRoutineDataAccessInterface {
    private HashMap<String, Routine> routineList;
    private String path;
    private ApiToDaoInterface apiAccess = new ApiAdapter();

    public RoutineDataAccessObject() {
        routineList = new HashMap<>();
        path = "RoutineFile.json";
    }

    public RoutineDataAccessObject(HashMap<String, Routine> routineList, String path) {
        this.routineList = routineList;
        this.path = path;
    }

    /**
     * Methods for saving and for reading json file
     *
     */

    // Converts json of routines into hashmap
    public HashMap<String, Routine> read() {
        try {
            File file = new File(path);
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();

            if (stringBuilder.isEmpty()) {
                return new HashMap<>();
            }

            final ObjectMapper mapper = new ObjectMapper();
            HashMap mapping = mapper.readValue(stringBuilder.toString(), HashMap.class);

            ArrayList<String> keys = new ArrayList<>(mapping.keySet());
            ArrayList<Routine> routines = new ArrayList<>();

            for (String key : keys) {
                ArrayList<Exercise> exercises = new ArrayList<>();

                // Routine information (name:... exerciseList: ...)
                LinkedHashMap linkedHashMap = (LinkedHashMap) mapping.get(key);

                // Name of routine
                String name = (String) linkedHashMap.get("name");

                // Now exercisesList (arraylist of linked hash maps)
                ArrayList exercisesList = (ArrayList) linkedHashMap.get("exercisesList");

                // Going through exercisesList
                for (Object exercise : exercisesList) {
                    LinkedHashMap ex = (LinkedHashMap) exercise;
                    exercises.add(ExerciseFactory.create((String) ex.get("name"), (String) ex.get("target"), (String) ex.get("equipment"), (ArrayList<String>) ex.get("instructions"), (String) ex.get("id"), (int) ex.get("sets"), (int) ex.get("reps")));
                }

                Routine routine = RoutineFactory.create(name);
                routine.setExercisesList(exercises);
                routines.add(routine);
            }

            HashMap<String, Routine> hashMap = new HashMap<>();

            for (Routine r : routines) {
                hashMap.put(r.getRoutineName(), r);
            }
            return hashMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
     * Setters and getters
     */

    public void setRoutineList(HashMap<String, Routine> routineList) {
        this.routineList = routineList;
    }

    public HashMap<String, Routine> getRoutineList() {
        return routineList;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
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
            if (exercises.get(i).getName().equals(id)) {
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
        this.save();
    }


    // For RenameRoutineDataAccessInterface
    @Override
    public void changeName(String identifier, String newName) {
        Routine routine = routineList.get(identifier);
        routine.setName(newName);
        routineList.put(newName, routine);
        routineList.remove(identifier);
        this.save();
    }

    // For AddRoutineDataAccessInterface and GenerateRoutineDataAccessInterface
    @Override
    public void addRoutine(Routine routine) {
        routineList.put(routine.getRoutineName(), routine);
        this.save();
    }

    // For AddExerciseDataAccessInterface, assumes exercises is of length 1
    @Override
    public void addExercise(String identifier, ArrayList<Exercise> exercises) {
        ArrayList<Exercise> currExercises = routineList.get(identifier).getExercisesList();
        currExercises.add(exercises.get(0));
        routineList.get(identifier).setExercisesList(currExercises);
        this.save();
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
        this.save();
    }

    // For LookUpRoutineDataAccessInterface
    @Override
    public Routine getRoutine(String name) {
        return routineList.get(name);
    }

    // For LookUpRoutinesDataAccessInterface
    @Override
    public ArrayList<Routine> getRoutines() {
        ArrayList<Routine> routines = new ArrayList<>();
        for (String name : routineList.keySet()) {
            routines.add(routineList.get(name));
        }
        return routines;
    }

    /**
     * The following are exercise-related methods for use case
     */

    // For GenerateRoutineDataAccessInterface
    @Override
    public ArrayList<Exercise> getExercisesByTarget(String target, int numberOfExercises) {
        Response response = apiAccess.getApiTarget(target, numberOfExercises);
        return convertResponse(response);
    }

    // For AddExerciseDataAccessInterface
//    @Override
    public ArrayList<Exercise> getExercisesByName(String name, int numberOfExercises) {
        Response response = apiAccess.getApiName(name, numberOfExercises);
        return convertResponse(response);
    }

    // Converts api response to array list of exercise entities
    private ArrayList<Exercise> convertResponse(Response response) {
        try {
            ResponseBody responseBody = response.body();
            assert responseBody != null;

            String responseBodyStr = responseBody.string();
            JSONTokener jsonTokener = new JSONTokener(responseBodyStr);
            JSONArray jsonArray = new JSONArray(jsonTokener);

            // Generating array list of exercises from jsonArray
            ArrayList<Exercise> exercises = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                ArrayList<String> instructions = new ArrayList<>(Arrays.asList(object.optString("instructions").replaceAll("[\\[\\]]", "").split(",")));
                Exercise exercise = ExerciseFactory.create(object.getString("name"), object.getString("target"), object.getString("equipment"), instructions, object.getString("id"), 0, 0);
                exercises.add(exercise);
            }
            return exercises;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
