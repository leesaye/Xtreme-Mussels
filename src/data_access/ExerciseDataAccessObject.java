package data_access;

import entity.Exercise;
import okhttp3.Response;
import use_case.lookup.LookUpDataAccessInterface;

import java.util.ArrayList;

public class ExerciseDataAccessObject implements LookUpDataAccessInterface {

    private final ApiToDaoInterface apiAccess = new ApiAdapter();

    // For LookUpDataAccessInterface, returns all exercises
    @Override
    public ArrayList<Exercise> getExercisesByQuery(String value, String query) {
        Response response = apiAccess.getApiByQuery(value, query);
        return apiAccess.convertResponse(response);
    }
}
