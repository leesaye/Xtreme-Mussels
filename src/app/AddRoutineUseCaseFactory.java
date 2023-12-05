//package app;
//
//import entity.RoutineFactory;
//import interface_adapter.ViewManagerModel;
//import interface_adapter.add_routine.AddRoutineController;
//import interface_adapter.add_routine.AddRoutinePresenter;
//import interface_adapter.add_routine.AddRoutineViewModel;
//import use_case.add_routine.AddRoutineDataAccessInterface;
//import use_case.add_routine.AddRoutineInputBoundary;
//import use_case.add_routine.AddRoutineInteractor;
//import use_case.add_routine.AddRoutineOutputBoundary;
//import view.AddRoutineView;
//
//import javax.swing.*;
//import java.io.IOException;
//
//public class AddRoutineUseCaseFactory {
//    private AddRoutineUseCaseFactory() {}
//    static RoutineFactory routineFactory;
//    public static AddRoutineView create(ViewManagerModel viewManagerModel,
//                                        AddRoutineViewModel addRoutineViewModel, AddRoutineDataAccessInterface addRoutineDataAccessInterface) {
//        try {
//            AddRoutineController addRoutineController = createAddRoutineUseCase(viewManagerModel, addRoutineViewModel, addRoutineDataAccessInterface);
//            return new AddRoutineView(addRoutineController, addRoutineViewModel);
//
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not");
//
//
//        }
//        return null;
//    }
//
//    static AddRoutineController createAddRoutineUseCase(ViewManagerModel viewManagerModel, AddRoutineViewModel addRoutineViewModel, AddRoutineDataAccessInterface addRoutineDAO) throws IOException {
//        AddRoutineOutputBoundary addRoutineOutputBoundary = new AddRoutinePresenter(viewManagerModel, addRoutineViewModel);
//
//        AddRoutineInputBoundary addRoutineInteractor =  new AddRoutineInteractor(addRoutineDAO, addRoutineOutputBoundary, routineFactory);
//
//        return new AddRoutineController(addRoutineInteractor);
//    }
//}