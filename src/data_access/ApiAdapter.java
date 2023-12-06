package data_access;

import entity.Exercise;
import entity.ExerciseFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ApiAdapter implements ApiToDaoInterface {

    public Response getApiTarget(String target, int numberOfExercises) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://exercisedb.p.rapidapi.com/exercises/target/" + target + "?limit=" + numberOfExercises)
                .get()
                .addHeader("X-RapidAPI-Key", "daf37a4550mshe8558bf065f22bep108a09jsnb2e44cc78573")
                .addHeader("X-RapidAPI-Host", "exercisedb.p.rapidapi.com")
                .build();
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Response getApiName(String name, int numberOfExercises) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://exercisedb.p.rapidapi.com/exercises/name/" + name + "?limit=" + numberOfExercises)
                .get()
                .addHeader("X-RapidAPI-Key", "daf37a4550mshe8558bf065f22bep108a09jsnb2e44cc78573")
                .addHeader("X-RapidAPI-Host", "exercisedb.p.rapidapi.com")
                .build();
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // No limit, returns all
    public Response getApiByQuery(String value, String query) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request;
        if (query.equals("target")) {
            request = new Request.Builder()
                    .url("https://exercisedb.p.rapidapi.com/exercises/target/" + value)
                    .get()
                    .addHeader("X-RapidAPI-Key", "daf37a4550mshe8558bf065f22bep108a09jsnb2e44cc78573")
                    .addHeader("X-RapidAPI-Host", "exercisedb.p.rapidapi.com")
                    .build();
        } else {    // query is either "target" or "name"
            request = new Request.Builder()
                    .url("https://exercisedb.p.rapidapi.com/exercises/name/" + value.replaceAll("\\s","%20"))
                    .get()
                    .addHeader("X-RapidAPI-Key", "daf37a4550mshe8558bf065f22bep108a09jsnb2e44cc78573")
                    .addHeader("X-RapidAPI-Host", "exercisedb.p.rapidapi.com")
                    .build();
        }
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Converts api response to array list of exercise entities
    public ArrayList<Exercise> convertResponse(Response response) {
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
