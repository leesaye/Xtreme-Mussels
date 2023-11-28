package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Exercise;
import entity.ExerciseFactory;
import entity.Routine;
import entity.RoutineFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RoutineToJson {
    private Routine routine;
    private final HashMap<String, Routine> routineList = new HashMap<>();
    private String path;
    public static void main(String[] args) throws IOException {
        ExerciseFactory exFac = new ExerciseFactory();
        ApiRoutineMediator med = new ApiRoutineMediator(exFac);
        ArrayList<Exercise> ex = med.getExerciseByTarget("cardiovascular system", 12);
        RoutineFactory rFac = new RoutineFactory();
        Routine routine1 = rFac.create("test1", ex);
        Routine routine2 = rFac.create("test2", ex);
        Routine routine3 = rFac.create("test3", ex);
        Routine routine62 = rFac.create("626262", ex);
        RoutineToJson r = new RoutineToJson();
//        r.addToJson(routine1, "TestRoutineFile.json");
        r.routineList.put("test1", routine1);
        r.routineList.put("test2", routine2);
        r.routineList.put("test3", routine3);
        r.writeAllToJson(r.routineList, "TestRoutineFile.json");
        r.addRoutineToJson(routine62,"TestRoutineFile.json");
    }

    // Adds one routine to json
    public void addToJson(Routine routine, String path) {
        try {
            final StringWriter sw = new StringWriter();
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(sw, routine);
            String json = sw.toString();
            System.out.println(json);
            sw.close();

            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Writes all routines to json (save method basically!)
    public void writeAllToJson(HashMap<String, Routine> routineList, String path) {
        try {
            final StringWriter sw = new StringWriter();
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(sw, routineList);
            String json = sw.toString();
            System.out.println(json);
            sw.close();

            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adds a routine to json file
    public void addRoutineToJson(Routine routine, String path) {
        try {
            routineList.put(routine.getName(), routine);

            final StringWriter sw = new StringWriter();
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(sw, routineList);
            String json = sw.toString();
            System.out.println(json);
            sw.close();

            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //

}
