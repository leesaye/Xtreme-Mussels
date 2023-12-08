package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import entity.RoutineFactory;
import okhttp3.Response;
import use_case.add_exercise.AddExerciseDataAccessInterface;
import use_case.add_routine.AddRoutineDataAccessInterface;
import use_case.delete_exercise.DeleteExerciseDataAccessInterface;
import use_case.generate_routine.GenerateRoutineDataAccessInterface;
import use_case.lookup_routine.LookUpRoutineDataAccessInterface;
import use_case.adjust_setrep.AdjustSetRepDataAccessInterface;
import use_case.rename_routine.RenameRoutineDataAccessInterface;
import use_case.lookup_routines.LookUpRoutinesDataAccessInterface;
import use_case.delete_routine.DeleteRoutineDataAccessInterface;

import java.io.*;
import java.util.*;

/**
 * @author lisa
 * @version 1.1, 4 Dec 2023
 */
public class RoutineDataAccessObject implements AddExerciseDataAccessInterface, AddRoutineDataAccessInterface, AdjustSetRepDataAccessInterface, DeleteExerciseDataAccessInterface,
        GenerateRoutineDataAccessInterface, LookUpRoutineDataAccessInterface, LookUpRoutinesDataAccessInterface, RenameRoutineDataAccessInterface, DeleteRoutineDataAccessInterface  {
    /**
     * Hashmap storing the routine name and its associated routine entity.
     */
    private HashMap<String, Routine> routineList;

    /**
     * String representing path to JSON file storing all routines.
     */
    private String path;

    /**
     * Adapter object that converts the API to an Arraylist of Exercise entities
     * @see ApiAdapter
     */
    private ApiToDaoInterface apiAccess = new ApiAdapter();

    /**
     * Default constructor for RoutineDataAccessObject
     */
    public RoutineDataAccessObject() {
        routineList = new HashMap<>();
        path = "RoutineFile.json";
    }

    /**
     * Constructor for RoutineDataAccessObject
     * @param routineList the Hashmap representing all routines in file
     * @param path the file path to the JSON file storing all routines
     */
    public RoutineDataAccessObject(HashMap<String, Routine> routineList, String path) {
        this.routineList = routineList;
        this.path = path;
    }

    /**
     * Method that reads the JSON file this object refers to
     * and converts it into the Hashmap format valid for routineList
     * @return the Hashmap representing all routines
     */
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
                String name = (String) linkedHashMap.get("routineName");

                // exercisesList (arraylist of linked hash maps)
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

    /**
     * Method that saves all routines (as represented in Hashmap) to the file.
     */
    public void save() {
        this.save(routineList, path);
    }

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
     * Setter method for Hashmap routineList
     * @param routineList the Hashmap representing all routines in file
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
     * Method to remove a routine, intended for use in tests
     * (specifically for the GenerateRoutine use case).
     * May be extended to its own use case in the future.
     * @param routineName Unique string identifier of routine, also known as its name
     */
    public void removeRoutine(String routineName) {
        routineList.remove(routineName);
        this.save();
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

    // For LookUpRoutineDataAccessInterface and AdjustSetRepDataAccessInterface
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

    //For DeleteRoutineDataAccessInterface
    @Override
    public void deleteRoutine(String routineName){
        routineList.remove(routineName);
        this.save();
    }

    /**
     * The following are exercise-related methods for use case
     */

    // For GenerateRoutineDataAccessInterface
    @Override
    public ArrayList<Exercise> getExercisesByTarget(String target, int numberOfExercises) {
        Response response = apiAccess.getApiTarget(target, numberOfExercises);
        return apiAccess.convertResponse(response);
    }

    // For AddExerciseDataAccessInterface
    @Override
    public ArrayList<Exercise> getExercisesByName(String name, int numberOfExercises) {
        Response response = apiAccess.getApiName(name, numberOfExercises);
        return apiAccess.convertResponse(response);
    }
}
