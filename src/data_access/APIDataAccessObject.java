package data_access;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class APIDataAccessObject {
    private final Response exerciseResponse;

    public static void main(String[] args) {
        // Writes a JSON file for now
        // TODO: getExercises from JSON
        APIDataAccessObject exercises = new APIDataAccessObject(getAPI());
        writeJSON(exercises.exerciseResponse);
    }

    // For now, just puts everything in a JSON - make it return DAO (from JSON) later
    public APIDataAccessObject(Response exerciseResponse) {
        this.exerciseResponse = exerciseResponse;
    }

    private static Response getAPI() {
        // From https://v2.exercisedb.io/docs/static/index.html
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://exercisedb.p.rapidapi.com/exercises?limit=1300")
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

    // Gets exercise and throws it into a JSON
    private static void writeJSON(Response exerciseResponse) {
        try {
            ResponseBody responseBody = exerciseResponse.body();

            assert responseBody != null;
            String responseBodyStr = responseBody.string();

            JSONTokener jsonTokener = new JSONTokener(responseBodyStr);
            JSONArray jsonArray = new JSONArray(jsonTokener);
            System.out.println(responseBodyStr);

            File file = new File("exercisesAll.json");
            String filePath = file.getAbsolutePath();
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonArray.toString());
            fileWriter.close();

        } catch (IOException e) {
            // TODO: Auto-generated catch block - change this!
            e.printStackTrace();
        }
    }
}

