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
import use_case.generate_routine.GenerateRoutineDataAccessInterface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


// for testing, removed extends ApiRoutineMediator implements GenerateRoutineDataAccessInterface
public class GenerateRoutineDataAccessObject {  // implements GenerateRoutineDataAccessInterface
//    private final File routineFile;
//    private ExerciseFactory exerciseFactory;

    // On construction of DAO make an empty json for saving generated routine
    public GenerateRoutineDataAccessObject(File routineFile, ExerciseFactory exerciseFactory) {
//        super(routineFile, exerciseFactory);
    }

    public static void main(String[] args) throws IOException {
        // Test code

//        GenerateRoutineDataAccessObject dao = new GenerateRoutineDataAccessObject(routineFile, exerciseFactory);
//        ArrayList<Exercise> e = dao.getExerciseByTarget("cardiovascular system", 12);
//
//        for (int i = 0; i < e.size(); i++) {
//            System.out.println(e);
//            System.out.println(e.get(i).getName());
//            System.out.println(e.get(i).getTarget());
//            System.out.println();
//        }
    }
}
