package data_access;

import entity.Exercise;
import entity.ExerciseFactory;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import use_case.lookup.LookUpDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static data_access.ApiDataAccessObject.getApiByQuery;

public class ExerciseApiAdapter implements LookUpDataAccessInterface {


    // For LookUpDataAccessInterface, returns all exercises
    @Override
    public ArrayList<Exercise> getExercisesByQuery(String value, String query) {
        Response response = getApiByQuery(value, query);
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
