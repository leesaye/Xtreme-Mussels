package data_access;

import entity.Exercise;
import okhttp3.Response;

import java.util.ArrayList;

public interface ApiToDaoInterface {

    Response getApiTarget(String target, int numberOfExercises);

    Response getApiName(String name, int numberOfExercises);

    Response getApiByQuery(String value, String query);

    ArrayList<Exercise> convertResponse(Response response);
}
