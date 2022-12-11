package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.ui.draganddrop.DragAndDropController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class TryLoadHolder {
    public static void tryLoad(FXMLLoader fxmlLoader) {
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    public static void tryLoadWithDragDropController(FXMLLoader fxmlLoader, CourseEntry courseEntry) {
        try {
            fxmlLoader.load();
            DragAndDropController.getInstance().setupDragSource(courseEntry);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }



}
