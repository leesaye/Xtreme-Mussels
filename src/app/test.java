package app;

import data_access.RoutineDataAccessObject;
import entity.Exercise;
import entity.Routine;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        RoutineDataAccessObject rdao = new RoutineDataAccessObject();
        rdao.setPath("testestest.json");
        rdao.setRoutineList(rdao.read());
        ArrayList<Exercise> ex = rdao.getExercisesByTarget("abs", 5);
        System.out.println(ex.get(0).getName());
        Routine r = new Routine("Test1");
        r.setExercisesList(ex);
        rdao.addRoutine(r);
        rdao.save();
    }
}