package data_access.testing;

import entity.Exercise;
import entity.ExerciseFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


// Assumes a routine json has already been created
// abstract, concrete for testing
public class ApiRoutineMediator {
    private File routineFile = null;
    private ExerciseFactory exerciseFactory;

    // Access only via json each time
//    private final Map<String, ArrayList<Exercise>> routinesInMemory = new HashMap<>();

    public ApiRoutineMediator(ExerciseFactory exerciseFactory) {
        this.exerciseFactory = exerciseFactory;
    }

    public ApiRoutineMediator(File routineFile, ExerciseFactory exerciseFactory) {
        this.routineFile = routineFile;
        this.exerciseFactory = exerciseFactory;
    }

    public Response getApi(String target, int numberOfExercises) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://exercisedb.p.rapidapi.com/exercises/target/" + target + "?limit=" + numberOfExercises)
                .get()
                .addHeader("X-RapidAPI-Key", "daf37a4550mshe8558bf065f22bep108a09jsnb2e44cc78573")
                .addHeader("X-RapidAPI-Host", "exercisedb.p.rapidapi.com")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Returns list of exercises by certain target, saves them to hashmap
    public ArrayList<Exercise> getExerciseByTarget(String target, int numberOfExercises) throws IOException {
        Response response = this.getApi(target, numberOfExercises);
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
            Exercise exercise = exerciseFactory.create(object.getString("name"), object.getString("target"), object.getString("equipment"), instructions, object.getString("id"), 0, 0);
            exercises.add(exercise);
        }

        return exercises;
    }

    // Saves new routine to routine storage json file
    // Note: file is json, in format of json of jarrays
    public void saveRoutine(File routineFile, String RoutineId, ArrayList<Exercise> exercises) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(routineFile));
            writer.write("{");
            writer.write(RoutineId);
            writer.write(" : [");

            for (int i = 0; i < exercises.size(); i++) {
                System.out.println(exercises.get(i));
                System.out.println(exerciseToJobj(exercises.get(i)).toString());
                writer.write(exerciseToJobj(exercises.get(i)).toString());

                if (i != exercises.size() - 1) {
                    writer.write(", ");
                }

                writer.newLine();
            }
            writer.write("]}");
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Writes the exercise entity into a json string (will lose the list type of instruction
//    public String exerciseToString(Exercise exercise) {
//        String jsonExerciseString = null;
//        String[] attributes = {"name", "target", "equipment", "instructions", "id", "sets", "reps"};
//        jsonExerciseString += exercise.getName() + exercise.getTarget() + exercise.getEquipment() + exercise.getInstructions() + exercise.getId() + exercise.getSets() + exercise.getReps();
//    }

    // Writes the exercise entity into a json object (needs jackson or otherwise)
    public JSONObject exerciseToJobj(Exercise exercise) {
        // via map
        String[] attributes = {"name", "target", "equipment", "instructions", "id", "sets", "reps"};
        // either rewrite the JSONObject constructor somehow, or use jackson, or do it all manually with strings
//        for (int i = 0; i < attributes.length; i++) {
//            Field f = exercise.getClass().getDeclaredField(attributes[i]); //NoSuchFieldException
//            f.setAccessible(true);
//        }
        JSONObject j = new JSONObject(exercise, attributes);
        System.out.println(j);
        return new JSONObject(exercise, attributes);
    }

    public static void main(String[] args) throws IOException {
        File test = new File("test.json");
        ExerciseFactory exFac = new ExerciseFactory();
        ApiRoutineMediator med = new ApiRoutineMediator(test, exFac);
        ArrayList<Exercise> ex = med.getExerciseByTarget("cardiovascular system", 12);
        med.saveRoutine(test, "test_routine_1", ex);
    }

}
