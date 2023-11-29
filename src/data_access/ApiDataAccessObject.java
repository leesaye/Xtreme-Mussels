package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ApiDataAccessObject {

    public static Response getApiTarget(String target, int numberOfExercises) {
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

    public static Response getApiName(String name, int numberOfExercises) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://exercisedb.p.rapidapi.com/exercises/name/" + name + "?limit=" + numberOfExercises)
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
}
