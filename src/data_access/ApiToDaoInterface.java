package data_access;

import okhttp3.Response;

public interface ApiToDaoInterface {

    Response getApiTarget(String target, int numberOfExercises);

    Response getApiName(String name, int numberOfExercises);

    Response getApiByQuery(String value, String query);
}
